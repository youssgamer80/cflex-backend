/*package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Position;
import projet.cflex.oda_cflex_smart_city1.Repository.PositionRepository;

@Repository
public class PositionServiceImpl implements PositionService {

    @Autowired(required = true)
    public PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findByTypeUser(String typeUser) {
        return positionRepository.findByTypeUser(typeUser);
    }

    @Override
    public Position findByUserId(String userId) {
        return positionRepository.findByUserId(userId);
    }

    @Override
    public List<Position> findAllByOrderByDateCreateDesc() {
        return positionRepository.findAllByOrderBydateCreateDesc();
    }

    @Override
    public Position saveOrUpdatePosition(Position position) {
        return positionRepository.save(position);
    }

}*/