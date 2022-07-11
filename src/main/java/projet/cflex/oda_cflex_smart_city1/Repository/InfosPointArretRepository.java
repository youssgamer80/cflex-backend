package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import projet.cflex.oda_cflex_smart_city1.Model.InfosPointArret;
import projet.cflex.oda_cflex_smart_city1.Model.TrackerCouloir;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

public interface InfosPointArretRepository extends MongoRepository<InfosPointArret, String>{
    
    // List<Tutorial> findByPublished(boolean published);
    Optional<InfosPointArret> findById(String id);

    public ArrayList<InfosPointArret> findAll();
}
