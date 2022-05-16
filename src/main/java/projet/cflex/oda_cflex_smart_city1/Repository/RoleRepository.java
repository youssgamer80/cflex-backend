package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import projet.cflex.oda_cflex_smart_city1.Model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    public Iterable<Role> findByStatut(Boolean statut);
	
	@Query("FROM Usager WHERE statut = ?1")
    public Iterable<Role> findByStatutJPQL(Boolean statut);
}