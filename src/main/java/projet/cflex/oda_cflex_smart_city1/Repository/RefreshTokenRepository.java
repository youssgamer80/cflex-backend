package projet.cflex.oda_cflex_smart_city1.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.RefreshToken;
import projet.cflex.oda_cflex_smart_city1.Model.User;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
  Optional<RefreshToken> findByToken(String token);

  @Modifying
  int deleteByUser(User user);
}