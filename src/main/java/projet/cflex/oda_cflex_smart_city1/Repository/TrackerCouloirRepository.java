package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import projet.cflex.oda_cflex_smart_city1.Model.TrackerCouloir;

import java.util.List;

import java.util.Optional;

public interface TrackerCouloirRepository extends MongoRepository<TrackerCouloir, String>{
    
  //List<Tutorial> findByPublished(boolean published);
  Optional<TrackerCouloir> findByIdcouloir(String idcouloir);

}
