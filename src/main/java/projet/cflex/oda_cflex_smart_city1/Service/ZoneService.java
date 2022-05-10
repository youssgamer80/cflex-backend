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
    private Boolean statut=true;

    public ZoneService(ZoneRepository ZoneRepo){
        this.ZoneRepo = ZoneRepo;
    }

    public List<Zone> listeZone(){
        return ZoneRepo.findAll();
    }


    public Zone ZoneById(Integer id){
        return ZoneRepo.findById(id).orElseThrow(() -> new RuntimeException("Zone" + id + "nexiste pas"));
    }

    //public Zone AddZone(Zone zone){
        //return ZoneRepo.save(zone);
    //}

    public void save (Zone zone){ZoneRepo.save(zone);}


    public Zone DeleteZone(Integer id, Zone zone){
        Zone realZone = this.ZoneRepo.findById(id).orElseThrow(() -> new RuntimeException("Zone" + id + "nexiste pas"));
        realZone.setStatut(zone.getStatut());
        return ZoneRepo.save(realZone);
    }


    
}


