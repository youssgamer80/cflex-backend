package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import projet.cflex.oda_cflex_smart_city1.Model.Zone;
import projet.cflex.oda_cflex_smart_city1.Repository.ZoneRepository;

@Service
public class ZoneService {

    @Autowired
    private final ZoneRepository ZoneRepo;

    public ZoneService(ZoneRepository ZoneRepo){
        this.ZoneRepo = ZoneRepo;
    }

    public List<Zone> listeZone(){
        return ZoneRepo.findAll();
    }


    /*public Zone ZoneById(Integer id){
        return ZoneRepo.findById(id).orElseThrow(() -> new RuntimeException("Zone " + id + " n'existe pas"));
    }*/

    public Optional<Zone> ZoneById(Integer id){
        return ZoneRepo.findById(id);

    }
    
    public Zone Addzone(Zone zone){
        return ZoneRepo.save(zone);
    }


    public Zone updateZone(Integer id, Zone zone){

        Zone existZone = this.ZoneRepo.findById(id).orElseThrow(() -> new RuntimeException("Zone" + id + "nexiste pas"));

        if (zone.getLibelle() != null) {
            existZone.setLibelle(zone.getLibelle());
        }
         if (zone.getIdTypeZoneFk()!=null) {
            existZone.setIdTypeZoneFk(zone.getIdTypeZoneFk());
         }

         if (zone.getZoneparent()!=null) {
            existZone.setZoneparent(zone.getZoneparent());
         }

         if(zone.getStatut()!= null){
            existZone.setStatut(zone.getStatut());;

        }

        return ZoneRepo.save(existZone);
    }


    public Zone deleteZone(Integer id){
        Zone realZone = this.ZoneRepo.findById(id).orElseThrow(() -> new RuntimeException("Zone" + id + "nexiste pas"));
        realZone.setStatut(false);
        return ZoneRepo.save(realZone);
    }
    
}


