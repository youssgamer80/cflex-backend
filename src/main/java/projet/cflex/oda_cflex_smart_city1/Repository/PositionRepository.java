package projet.cflex.oda_cflex_smart_city1.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository {

    Position save(Position position);

    List<Position> saveAll(List<Position> positions);

    List<Position> findAll();

    List<Position> findAll(List<String> ids);

    Position findOne(String id);


    Position update(Position position);

}
