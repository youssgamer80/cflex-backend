package projet.cflex.oda_cflex_smart_city1.Repository;

import java.util.List;

import com.mongodb.client.model.geojson.Position;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PositionRepository extends MongoRepository<Position, Integer> {
    
    @Query("{id:'?0'}")
    Position findItemById(int id);
    
    @Query(value="{user_id:'?0'}", fields="{'id' : 1, 'user_id' : 1}")
    List<Position> findAll(String user_id);
    
    public long count();

}
