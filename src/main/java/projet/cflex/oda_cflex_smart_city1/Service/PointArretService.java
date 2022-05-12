package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
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
    
    public PointArret NewPointArret( PointArret pointarret){
        return pointarretRepo.save(pointarret);
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
