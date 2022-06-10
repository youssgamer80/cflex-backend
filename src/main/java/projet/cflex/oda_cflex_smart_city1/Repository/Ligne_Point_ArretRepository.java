package projet.cflex.oda_cflex_smart_city1.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Ligne;
import projet.cflex.oda_cflex_smart_city1.Model.Ligne_Point_Arret;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Ligne_Point_ArretRepository extends JpaRepository<Ligne_Point_Arret, Integer>{


    @Query(value="SELECT * FROM ligne_point_arret WHERE id_ligne_fk=:idLigneFk",nativeQuery=true)
    public Iterable<Ligne_Point_Arret> findByIdLigneFkNative(@Param("idLigneFk") Integer idLigneFk);



    
}
