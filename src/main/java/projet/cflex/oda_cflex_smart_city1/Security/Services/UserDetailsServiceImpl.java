package projet.cflex.oda_cflex_smart_city1.Security.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.cflex.oda_cflex_smart_city1.Model.User;
import projet.cflex.oda_cflex_smart_city1.Repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
			User user = userRepository.findByEmail(email);
			if (user == null) {
				throw new UsernameNotFoundException("Not found!");
			}
			return UserDetailsImpl.build(user);
		
	}
}
