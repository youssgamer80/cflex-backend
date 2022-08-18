package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import projet.cflex.oda_cflex_smart_city1.Model.ERole;
import projet.cflex.oda_cflex_smart_city1.Model.Role;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}