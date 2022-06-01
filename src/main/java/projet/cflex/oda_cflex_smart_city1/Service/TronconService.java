package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import projet.cflex.oda_cflex_smart_city1.Model.PointArret;
import projet.cflex.oda_cflex_smart_city1.Model.Ligne_PointArret;
import projet.cflex.oda_cflex_smart_city1.Model.Troncon;
import projet.cflex.oda_cflex_smart_city1.Model.Ligne;
import projet.cflex.oda_cflex_smart_city1.Repository.TronconRepository;

@Service
public class TronconService {
    private Boolean statut=true;

    @Autowired
    private final TronconRepository tronconRepo;
    @Autowired
    public TronconService(TronconRepository tronconRepo) {
        this.tronconRepo = tronconRepo;
    }
    @Autowired
    private PointArretService pointArretService;

    public List<Troncon> Liste(){

        List<Troncon> troncons = new ArrayList<>();
        tronconRepo.findByStatutJPQL(statut).forEach(troncons::add);

        return troncons;
    }

    public Optional<Troncon> TronconById(Integer id){
        return tronconRepo.findById(id);

    }

    public List<Troncon> TronconByNom(String nom){
        List<Troncon> troncons = new ArrayList<>();
        tronconRepo.findByNom(nom).forEach(troncons::add);

        return troncons;
    }

    public Troncon deleteTroncon(Integer id){
        Troncon realTroncon = this.tronconRepo.findById(id).orElseThrow(() -> new RuntimeException("Troncon" + id + "nexiste pas"));
        realTroncon.setStatut(false);
        return tronconRepo.save(realTroncon);
    }

    

    public Troncon updateTroncon(Integer id, Troncon troncon) {

        Troncon existingTroncon = this.tronconRepo.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Troncon not found with id :" + id));

        if(troncon.getNom()!=null){
            existingTroncon.setNom(troncon.getNom());
        }

        if(troncon.getIdPointArretAFk()!=null){
            existingTroncon.setIdPointArretAFk(troncon.getIdPointArretAFk());
        }

        if(troncon.getIdPointArretBFk()!=null){
            existingTroncon.setIdPointArretBFk(troncon.getIdPointArretBFk());
        }

        if(troncon.getDistance()!=null){
            existingTroncon.setDistance(troncon.getDistance());
        }

        if(troncon.getDuree()!=null){
            existingTroncon.setDuree(troncon.getDuree());
        }

        if(troncon.getTarif()!=null){
            existingTroncon.setTarif(troncon.getTarif());
        }

        if(troncon.getStatut()!=null){
            existingTroncon.setStatut(troncon.getStatut());
        }

        if(troncon.getIdLigneFk()!=null){
            existingTroncon.setIdLigneFk(troncon.getIdLigneFk());
        }
       

		return tronconRepo.save(existingTroncon);
 }

 public Troncon detacherLigne(Integer id) {

    Troncon existingTroncon = this.tronconRepo.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("Troncon not foundwith id :" + id));
    existingTroncon.setIdLigneFk(null);
    return tronconRepo.save(existingTroncon);
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


    public List<Troncon> Generatetroncon(@RequestParam Ligne_PointArret Ligne_PointArrets){
        double el1 = 0;
        double el2 = 0;
        List<Troncon> TronconsGeneres = new ArrayList<>();
        double distanceij;

        for (int i = 1; i <= Ligne_PointArrets.getPoints().length; i++) {
            for (int j = 1; j <= Ligne_PointArrets.getPoints().length; j++) {

                PointArret pointarret1 = pointArretService.getPointArret(Ligne_PointArrets.getPoints()[i-1]);
                PointArret pointarret2 = pointArretService.getPointArret(Ligne_PointArrets.getPoints()[j-1]);
                distanceij = distance(pointarret1.getLatitude(), pointarret2.getLatitude(), pointarret1.getLongitude(), pointarret2.getLongitude(), el1, el2);
                String nom="troncon(" + Ligne_PointArrets.getPoints()[i-1] + "," + Ligne_PointArrets.getPoints()[j-1] + ")";
                Integer duree = 0;
                Integer tarif = 0;
                Boolean statut = true;
                Ligne idLigneFk = new Ligne();
                idLigneFk.setId(Ligne_PointArrets.getId_ligne());


                if (i != j) {

                    Troncon troncon = new Troncon( nom,  pointarret1,  pointarret2,  distanceij,  duree,  tarif,  statut,  idLigneFk);
             
                    tronconRepo.save(troncon);
                    TronconsGeneres.add(troncon);
                    System.out.println("troncon(" + Ligne_PointArrets.getPoints()[i-1] + "," + Ligne_PointArrets.getPoints()[j-1] + ")");
                    
                }              
                
            }
        }   
        
        return TronconsGeneres;

    }
    
}
