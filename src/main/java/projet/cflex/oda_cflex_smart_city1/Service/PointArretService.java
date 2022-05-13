package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Reiterating;
import projet.cflex.oda_cflex_smart_city1.Model.PointArret;
import projet.cflex.oda_cflex_smart_city1.Repository.PointArretRepository;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

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




    //public List<PointArret> ListePointArret() {
        
        //List<PointArret> pointarret = new ArrayList<>();

       //pointarretRepo.findByStatutJPQL(statut).forEach(pointarret::add);

        //return pointarret;
    //}

    //public PointArret PointById(Integer id){
        //return pointarretRepo.findById(id).orElseThrow(() -> new RuntimeException("Point d arret" + id + "nexiste pas"));
    //}

    public Optional<PointArret> PointById(Integer id){
        return pointarretRepo.findById(id);

    }


    //public Optional<PointArret> Points(Integer id, String longitude, String position, String latitude ){
        //return pointarretRepo.findById(id);
        //return pointarretRepo.findBy(longitude, queryFunction)

    //}
    
    public Object NewPointArret( PointArret pointarret){


        /*if (pointarret.getLongitude() == null) {
            return ("Veillez entrer la longitude");
        }

        if (pointarret.getPosition() == null) {
            return ("Veillez entrer la position");
        }

        if (pointarret.getLatitude() == null) {
            return ("Veillez entrer la latitude");
        }*/

        if(pointarret.getLongitude() != null  && pointarret.getPosition() != null && pointarret.getLatitude() != null){
            return pointarretRepo.save(pointarret);
        } 
        else {
            return ("veuillez renseigner tous les champs");
        }   
        
    }

    public PointArret updatePointArret(Integer id, PointArret pointdarret){
        
        PointArret realPA = this.pointarretRepo.findById(id).orElseThrow(() -> new RuntimeException("Point darret" + id + "nexiste pas"));

        if(pointdarret.getLongitude()== null){
            pointdarret.setLongitude(realPA.getLongitude());

        }
    
        if(pointdarret.getPosition()==null){
            pointdarret.setPosition(realPA.getPosition());
        }
    
        if(pointdarret.getLatitude()==null){
            pointdarret.setLatitude(realPA.getLatitude());
        }
        
        return pointarretRepo.save(pointdarret);

    } 



    public PointArret deletePointArret(Integer id, PointArret pointdarret){
        PointArret realPA = this.pointarretRepo.findById(id).orElseThrow(() -> new RuntimeException("Point darret" + id + "nexiste pas"));
        realPA.setStatut(pointdarret.getStatut());
        return pointarretRepo.save(realPA);
    }

    
}
