package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Borne;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import projet.cflex.oda_cflex_smart_city1.Repository.BorneRepository;

@Service
public class BorneService {
    
    @Autowired
    public BorneRepository borneRepository;
    private Boolean statut=true;


    // list of methods 
    public List<Borne> getAllBornes() {
        
        List<Borne> bornes = new ArrayList<>();

        borneRepository.findByStatutJPQL(statut).forEach(bornes::add);

        return bornes;
    }

    public Borne getBorne(int id) {

        return this.borneRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Borne not found with id :" + id));
    }

    public Borne deleteBorne(Integer id, Borne usager) {

        Borne existingBorne = this.borneRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Borne not found with id :" + id));
		 existingBorne.setStatut(usager.getStatut());
		 return borneRepository.save(existingBorne);
    }

    public Borne updateBorne(Borne borne,Integer id) {

        Borne existingBorne = this.borneRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Borne not found with id :" + id));
        if(borne.getLibelle()!=null){
            existingBorne.setLibelle(borne.getLibelle());
        }

		if(borne.getIdPointArretFk()!=null){
            existingBorne.setIdPointArretFk(borne.getIdPointArretFk());
       }

       if(borne.getStatut()!=null){
        existingBorne.setStatut(borne.getStatut());
       }

		return borneRepository.save(existingBorne);
    }

    public  Borne addBorne(Borne borne) {

        return borneRepository.save(borne);
    }
}
