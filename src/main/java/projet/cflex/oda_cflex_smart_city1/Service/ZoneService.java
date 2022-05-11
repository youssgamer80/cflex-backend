package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


    public Zone ZoneById(Integer id){
        return ZoneRepo.findById(id).orElseThrow(() -> new RuntimeException("Zone" + id + "nexiste pas"));
    }

    //public void save (Zone zone){ZoneRepo.save(zone);}
    public Zone NewZone(Zone zone){
        return ZoneRepo.save(zone);
    }


    public Zone DeleteZone(Integer id, Zone zone){
        Zone realZone = this.ZoneRepo.findById(id).orElseThrow(() -> new RuntimeException("Zone" + id + "nexiste pas"));
        realZone.setStatut(zone.getStatut());
        return ZoneRepo.save(realZone);
    }

    public Zone updateZone(Integer id, Zone zone){
        return ZoneRepo.save(zone);
    }







    
}

