package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Zoneparent;
import projet.cflex.oda_cflex_smart_city1.Repository.ZoneparentRepository;

@Service
public class ZoneparentService {

    @Autowired
    public ZoneparentRepository zoneparentRepository;
    private Boolean statut=true;
    public Zoneparent zoneparent;


    public List<Zoneparent> getAllZoneparents() {
        
        List<Zoneparent> zoneparents = new ArrayList<>();

        zoneparentRepository.findByStatutJPQL(statut).forEach(zoneparents::add);

        return zoneparents;
    }
    
    public Zoneparent addZoneparent(Zoneparent zoneparent) {

        return zoneparentRepository.save(zoneparent);
    }

    public Zoneparent getZoneparent(int id) {

        return this.zoneparentRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Zoneparent not found with id :" + id));
    }

    public Zoneparent updateZoneparent(Integer id, Zoneparent zoneparent) {

        Zoneparent existingZoneparent = this.zoneparentRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Usager not found with id :" + id));
        if(zoneparent.getZoneparent()!=null){
             existingZoneparent.setZoneparent(zoneparent.getZoneparent());
        }

       if(zoneparent.getStatut()!=null){
        existingZoneparent.setStatut(zoneparent.getStatut());
   }

		return zoneparentRepository.save(existingZoneparent);
    }

    public Zoneparent deleteZoneparent(Integer id) {

        Zoneparent existingZoneparent = this.zoneparentRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Zone parent not found with id :" + id));
            existingZoneparent.setStatut(false);
		 return zoneparentRepository.save(existingZoneparent);
    }
    

}