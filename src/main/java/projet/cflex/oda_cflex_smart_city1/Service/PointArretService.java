package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.PointArret;
import projet.cflex.oda_cflex_smart_city1.Repository.PointArretRepository;

@Service
public class PointArretService {

    @Autowired
    private final PointArretRepository pointarretRepo;

    @Autowired
    public PointArretService(PointArretRepository pointarretRepo) {
        this.pointarretRepo = pointarretRepo;
    }



    public List<PointArret> ListePointArret(){
        return pointarretRepo.findAll();
    }

    public PointArret PointById(Integer id){
        return pointarretRepo.findById(id).orElseThrow(() -> new RuntimeException("Point d arret" + id + "nexiste pas"));
    }

    public void save (PointArret newpointarret){pointarretRepo.save(newpointarret);}
    
}
