package projet.cflex.oda_cflex_smart_city1.MongoDB.repository;

import projet.cflex.oda_cflex_smart_city1.MongoDB.model.Tracker;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TrackerRepository extends MongoRepository<Tracker, String> {
  //List<Tutorial> findByPublished(boolean published);
  List<Tracker> findByTypetransport(String typetransport);
}
