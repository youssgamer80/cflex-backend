package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.TypeTransport;

@Repository
public interface TypeTransportRepository extends CrudRepository<TypeTransport, Integer> {

    public Iterable<TypeTransport> findByStatut(Boolean statut);
	
	@Query("FROM TypeTransport WHERE statut = ?1")
    public Iterable<TypeTransport> findByStatutJPQL(Boolean statut);
    
    @Query("FROM TypeTransport WHERE id = ?1")
    public TypeTransport findTypeTransport(Integer id);

    public TypeTransport findBylibelleTypeTransport(String libelleTypeTransport);	

}