package projet.cflex.oda_cflex_smart_city1.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.bytebuddy.utility.RandomString;
import projet.cflex.oda_cflex_smart_city1.Model.User;
import projet.cflex.oda_cflex_smart_city1.Repository.UserRepository;

@Service
@Transactional
public class UserService {
 
    @Autowired
    private UserRepository userRepo;
     
    
 
    /*public User updateResetPasswordToken(String token,String YourresetPasswordLink, User user) throws UserPrincipalNotFoundException {
        String email = user.getEmail();
        String resetToken = RandomString.make(30);
        User Existinguser = userRepo.findByEmail(email);
        if (Existinguser != null) {
            user.setResetPasswordToken(token);
            String resetPasswordLink = YourresetPasswordLink+"?token="+token;
            sendotp(email, resetPasswordLink);
        model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
           return userRepo.save(user);
        } else {
            throw new UserPrincipalNotFoundException("Could not find any customer with the email " + email);
        }
    }*/
     
    public User getByResetPasswordToken(String token) {
        return userRepo.findByResetPasswordToken(token);
    }
     
    public void updatePassword(User user, String newPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
         
        user.setResetPasswordToken(null);
        userRepo.save(user);
    }
}
