package projet.cflex.oda_cflex_smart_city1.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projet.cflex.oda_cflex_smart_city1.Service.ProprietaireService;
import projet.cflex.oda_cflex_smart_city1.Model.ERole;

import projet.cflex.oda_cflex_smart_city1.Model.Role;
import projet.cflex.oda_cflex_smart_city1.Model.User;
import projet.cflex.oda_cflex_smart_city1.Repository.ProprietaireRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.RoleRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.UserRepository;
import projet.cflex.oda_cflex_smart_city1.Response.Response;
import projet.cflex.oda_cflex_smart_city1.Security.jwt.JwtUtils;
import projet.cflex.oda_cflex_smart_city1.Service.UserService;
import projet.cflex.oda_cflex_smart_city1.payload.request.SignUpProprietaire;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/proprietaires")
@RequiredArgsConstructor
public class SaveProprietaireController {
  protected static SecureRandom random = new SecureRandom();
  @Autowired
  private final ProprietaireService proprietaireService;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserService userService;
  @Autowired
  ProprietaireRepository proprietaireRepository;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  RoleRepository roleRepository;
  @Autowired
  PasswordEncoder encoder;
  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/save")
  @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
  public ResponseEntity<Object> saveProprietaire(@RequestBody @Validated SignUpProprietaire proprietaire) {

    if (userRepository.existsByUsername(proprietaire.getTelephone())) {

      return ResponseEntity.badRequest()
          .body("Error Telephone already taken");

    }
    if (userRepository.existsByEmail(proprietaire.getEmail())) {
      return ResponseEntity.badRequest().body("Error: Email is already in use!");
    }
    // Create new user's account
    User user = new User(proprietaire.getTelephone(),
        proprietaire.getEmail(),
        encoder.encode(proprietaire.getPassword()),proprietaire.getPrenom(),proprietaire.getNom(),proprietaire.getTelephone());
    Set<String> strRoles = proprietaire.getRole();
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
          case "proprietaire":
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
    user.setRoles(roles);
    userRepository.save(user);
    return ResponseEntity.ok(
        Response.builder().timeStamp(now()).data(Map.of("proprietaire", proprietaireService.addProprio(proprietaire)))
            .message("Proprietaire enregistré avec succès")
            .status(CREATED)
            .statusCode(CREATED.value())
            .build());
  }
}
