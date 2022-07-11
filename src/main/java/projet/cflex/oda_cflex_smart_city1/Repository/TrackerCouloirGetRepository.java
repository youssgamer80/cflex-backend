package projet.cflex.oda_cflex_smart_city1.Repository;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import projet.cflex.oda_cflex_smart_city1.Model.TrackerCouloir;
import projet.cflex.oda_cflex_smart_city1.Model.TrackerCouloirGet;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

public interface TrackerCouloirGetRepository extends MongoRepository<TrackerCouloirGet, String> {

    // List<Tutorial> findByPublished(boolean published);
    List<TrackerCouloirGet> findByIdcouloir(String idcouloir);

    public ArrayList<TrackerCouloirGet> findAll();

}
