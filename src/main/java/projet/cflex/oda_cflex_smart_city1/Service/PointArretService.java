package projet.cflex.oda_cflex_smart_city1.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.cflex.oda_cflex_smart_city1.Model.PointArret;
import projet.cflex.oda_cflex_smart_city1.Repository.PointArretRepository;

@Service
public class PointArretService {

    @Autowired
    private final PointArretRepository pointarretRepo;
    //private Boolean statut= true;

    @Autowired
    public PointArretService(PointArretRepository pointarretRepo) {
        this.pointarretRepo = pointarretRepo;
    }

    public List<PointArret> Liste(){
        return pointarretRepo.findAll();
    }


    public Optional<PointArret> PointById(Integer id){
        return pointarretRepo.findById(id);

    }
    
    public Object NewPointArret( PointArret pointarret){


        if(pointarret.getNom() != null && pointarret.getLongitude() != null  && pointarret.getLatitude() != null){
            pointarret.setStatut(true);
            return pointarretRepo.save(pointarret);
        } 
        else {
            return ("veuillez renseigner tous les champs");
        }   
        
    }

    public PointArret updatePointArret(Integer id, PointArret pointdarret){
        
        PointArret realPA = this.pointarretRepo.findById(id).orElseThrow(() -> new RuntimeException("Point darret" + id + "nexiste pas"));

        if(pointdarret.getNom()!=null){
            realPA.setNom(pointdarret.getNom());
        }

        if(pointdarret.getLongitude()!= null){
            realPA.setLongitude(pointdarret.getLongitude());

        }
    
        if(pointdarret.getLatitude()!=null){
            realPA.setLatitude(pointdarret.getLatitude());
        }
        
        if(pointdarret.getStatut()!=null){
            realPA.setStatut(pointdarret.getStatut());
        }

        return pointarretRepo.save(realPA);

    } 



    public PointArret deletePointArret(Integer id){
        PointArret realMD = this.pointarretRepo.findById(id).orElseThrow(() -> new RuntimeException("Point d'arrêt" + id + "nexiste pas"));
        realMD.setStatut(false);
        return pointarretRepo.save(realMD);
    }

    
}
