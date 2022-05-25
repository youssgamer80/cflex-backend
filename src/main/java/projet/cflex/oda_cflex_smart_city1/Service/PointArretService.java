package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.PointArret;
import projet.cflex.oda_cflex_smart_city1.Repository.PointArretRepository;

@Service
public class PointArretService {

    @Autowired
    public PointArretRepository pointarretRepository;
    private Boolean statut=true;
    public PointArret pointarret;


    public List<PointArret> getAllPointArret() {
        
        List<PointArret> pointarrets = new ArrayList<>();

        pointarretRepository.findByStatutJPQL(statut).forEach(pointarrets::add);

        return pointarrets;
    }
    
    public PointArret addPointArret(PointArret pointarret) {

        return pointarretRepository.save(pointarret);
    }

    public PointArret getPointArret(int id) {

        return this.pointarretRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Point d'arret not found with id :" + id));
    }


    public PointArret updatePointArret(Integer id, PointArret pointarret) {

        PointArret existingPointArret = this.pointarretRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Point Arret not found with id :" + id));
        if(pointarret.getNom()!=null){
             existingPointArret.setNom(pointarret.getNom());
        }

		if(pointarret.getLongitude()!=0){
             existingPointArret.setLongitude(pointarret.getLongitude());
       }

       if(pointarret.getLatitude()!=0){
        existingPointArret.setLatitude(existingPointArret.getLatitude());
       }

       if(pointarret.getStatut()!=null){
        existingPointArret.setStatut(pointarret.getStatut());
   }

		return pointarretRepository.save(existingPointArret);
    }

    public PointArret deletePointArret(Integer id, PointArret pointarret) {

        PointArret existingPointArret = this.pointarretRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Point d'Arret not found with id :" + id));
		 existingPointArret.setStatut(pointarret.getStatut());
		 return pointarretRepository.save(existingPointArret);
    }
    

}