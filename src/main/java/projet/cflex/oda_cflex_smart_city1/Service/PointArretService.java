package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import projet.cflex.oda_cflex_smart_city1.Model.PointArret;
import projet.cflex.oda_cflex_smart_city1.Repository.PointArretRepository;

@Service
public class PointArretService {

    @Autowired
    public PointArretRepository pointarretRepository;
    private Boolean statut=true;
    //private Integer nbplaces = 10;
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
    
    public Iterable<PointArret> getPointArretByLibelle(String libelle) {


        return this.pointarretRepository.findByLibelleNative(libelle);
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

    public PointArret deletePointArret(Integer id){
        PointArret existingPointArret = this.pointarretRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Point d'Arret not found with id :" + id));
        existingPointArret.setStatut(false);
        return pointarretRepository.save(existingPointArret);
    }




    public static double distance(double lat1, double lat2, double lon1,
            double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                        * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);
        

        return Math.sqrt(distance);
    }

    public List<PointArret> getPointArretByCord(@RequestParam Map<String, String> requestParams) {

        String lonString = requestParams.get("lon");
        String latString = requestParams.get("lat");
        double lat = Double.parseDouble(latString);
        double lon = Double.parseDouble(lonString);

        double el1 = 0;
        double el2 = 0;

        
        List<PointArret> pointarretsrResultats = new ArrayList<>();
        List<PointArret> pointArrets = pointarretRepository.findByStatutJPQL(true);;
            pointArrets.forEach(
                    pointArret -> {
                        if (distance(lat, pointArret.getLatitude(), lon, pointArret.getLongitude(), el1, el2) <= 1000) {
                            System.out.println(distance(lat, pointArret.getLatitude(), lon, pointArret.getLongitude(), el1, el2));
                            System.out.println(pointArret.getNom());
                            pointarretsrResultats.add(pointArret);

                        }
                    });


        return pointarretsrResultats;
    }


        /*public Integer NbPersonnes(Integer id){
        PointArret existingPointArret = this.pointarretRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Point d'Arret not found with id :" + id));
        return nbplaces;
    }*/
    

}