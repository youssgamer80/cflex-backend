package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Zone;
import projet.cflex.oda_cflex_smart_city1.Repository.ZoneRepository;

@Service
public class ZoneService {

    @Autowired
    public ZoneRepository zoneRepository;
    private Boolean statut=true;
    public Zone zone;


    public List<Zone> getAllZones() {
        
        List<Zone> zones = new ArrayList<>();

        zoneRepository.findByStatutJPQL(statut).forEach(zones::add);

        return zones;
    }
    
    public Zone addZone(Zone zone) {

        return zoneRepository.save(zone);
    }
    

    public Zone getZone(int id) {

        return this.zoneRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Zone not found with id :" + id));
    }

    public Zone updateZone(Integer id, Zone zone) {

        Zone existingZone = this.zoneRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Zone not found with id :" + id));

        if(zone.getLibelle()!=null){
             existingZone.setLibelle(zone.getLibelle());
        }

        if(zone.getIdTypeZoneFk()!=null){
            existingZone.setIdTypeZoneFk(zone.getIdTypeZoneFk());
       }

       if(zone.getIdZoneparentFk()!=null){
        existingZone.setIdZoneparentFK(zone.getIdZoneparentFk());
       }
       
       if(zone.getStatut()!=null){
        existingZone.setStatut(zone.getStatut());
      }

		return zoneRepository.save(existingZone);
      }

    public Zone deleteZone(Integer id) {

        Zone existingZone = this.zoneRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Zone not found with id :" + id));
            existingZone.setStatut(false);
		 return zoneRepository.save(existingZone);
    }
    

}