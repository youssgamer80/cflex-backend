package projet.cflex.oda_cflex_smart_city1.Controller;

import projet.cflex.oda_cflex_smart_city1.Model.ERole;
import projet.cflex.oda_cflex_smart_city1.Model.RefreshToken;
import projet.cflex.oda_cflex_smart_city1.Model.Role;
import projet.cflex.oda_cflex_smart_city1.Model.User;
import projet.cflex.oda_cflex_smart_city1.payload.request.LogOutRequest;
import projet.cflex.oda_cflex_smart_city1.payload.request.LoginRequest;
import projet.cflex.oda_cflex_smart_city1.payload.request.SignupRequest;
import projet.cflex.oda_cflex_smart_city1.payload.request.TokenRefreshRequest;
import projet.cflex.oda_cflex_smart_city1.payload.response.MessageResponse;
import projet.cflex.oda_cflex_smart_city1.payload.response.TokenRefreshResponse;
import projet.cflex.oda_cflex_smart_city1.payload.response.UserInfoResponse;
import projet.cflex.oda_cflex_smart_city1.Repository.RoleRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.UserRepository;
import projet.cflex.oda_cflex_smart_city1.Security.jwt.JwtResponse;
import projet.cflex.oda_cflex_smart_city1.Security.jwt.JwtUtils;
import projet.cflex.oda_cflex_smart_city1.exception.TokenRefreshException;
import projet.cflex.oda_cflex_smart_city1.Security.Services.RefreshTokenService;
import projet.cflex.oda_cflex_smart_city1.Security.Services.UserDetailsImpl;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  RefreshTokenService refreshTokenService;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    String jwt = jwtUtils.generateJwtToken(userDetails);

    List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
        .collect(Collectors.toList());

    RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());

    return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(),
        userDetails.getUsername(), userDetails.getEmail(), userDetails.getNom(),userDetails.getPrenom(),userDetails.getTelephone(),roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
    }
    

    // Create new user's account
    User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
        encoder.encode(signUpRequest.getPassword()),signUpRequest.getPrenom(),signUpRequest.getNom(),signUpRequest.getTelephone());

    Set<String> strRoles = signUpRequest.getRole();
    System.out.println(signUpRequest.getRole());
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "prorietaire":
          Role proprietaireRole = roleRepository.findByName(ERole.ROLE_PROPRIETAIRE)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(proprietaireRole);

          break;
        default:
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    System.out.println(roles);
    user.setRoles(roles);
    userRepository.save(user);

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(signUpRequest.getEmail(), signUpRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    String jwt = jwtUtils.generateJwtToken(userDetails);

    List<String> role = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
        .collect(Collectors.toList());

    RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());

    return ResponseEntity.ok(new JwtResponse(jwt, refreshToken.getToken(), userDetails.getId(),
        userDetails.getUsername(), userDetails.getEmail(),userDetails.getNom(),userDetails.getPrenom(),userDetails.getTelephone(), role));
  }

  @PostMapping("/refreshtoken")
  public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
    String requestRefreshToken = request.getRefreshToken();

    return refreshTokenService.findByToken(requestRefreshToken)
        .map(refreshTokenService::verifyExpiration)
        .map(RefreshToken::getUser)
        .map(user -> {
          String token = jwtUtils.generateTokenFromUsername(user.getUsername());
          return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
        })
        .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
            "Refresh token is not in database!"));
  }
  
  @PostMapping("/signout")
  public ResponseEntity<?> logoutUser(@Valid @RequestBody LogOutRequest logOutRequest) {
    refreshTokenService.deleteByUserId(logOutRequest.getUserId());
    return ResponseEntity.ok(new MessageResponse("Log out successful!"));
  }
}