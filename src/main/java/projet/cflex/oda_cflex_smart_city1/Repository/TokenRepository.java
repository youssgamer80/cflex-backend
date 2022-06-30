package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projet.cflex.oda_cflex_smart_city1.Model.Token;

@Repository

public interface TokenRepository extends JpaRepository<Token, Integer> {
}