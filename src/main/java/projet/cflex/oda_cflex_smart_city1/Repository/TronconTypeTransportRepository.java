package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projet.cflex.oda_cflex_smart_city1.Model.TronconTypeTransport;

public interface TronconTypeTransportRepository extends JpaRepository<TronconTypeTransport, Integer>{

    @Query(value="SELECT * FROM troncon_type_transport WHERE id_troncon_fk=:idTronconFk AND statut = 1 ",nativeQuery=true)
    public Iterable<TronconTypeTransport> findByIdTronconFkNative(@Param("idTronconFk") Integer idTronconFk);

    //@Query("FROM * FROM troncon_type_transport WHERE statut = 1")

    // @Query(value="SELECT * FROM troncon_type_transport WHERE statut = 1")
    
    // public Iterable<TronconTypeTransport> findByStatutNative(Boolean statut);

    @Query("FROM TronconTypeTransport WHERE statut = ?1")
    public Iterable<TronconTypeTransport> findByStatutJPQL(Boolean statut);


    
}