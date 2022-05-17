package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Trajet;
import projet.cflex.oda_cflex_smart_city1.Repository.TrajetRepository;

@Service
public class TrajetService {

    @Autowired
    public TrajetRepository trajetRepository;
    private Boolean statut = true;
    public Trajet trajet;


    public List<Trajet> getAllTrajets() {
        
        List<Trajet> trajets = new ArrayList<>();

        trajetRepository.findByStatutJPQL(statut).forEach(trajets::add);

        return trajets;
    }
    
    public Trajet addTrajet(Trajet trajet) {

        return trajetRepository.save(trajet);
    }

    public Trajet getTrajet(int id) {

        return this.trajetRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Trajet not found with id :" + id));
    }

    public Trajet updateTrajet(Integer id, Trajet trajet) {

        Trajet existingTrajet = this.trajetRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Trajet not found with id :" + id));
        if(trajet.getDepart()!=null){
             existingTrajet.setDepart(trajet.getDepart());
        }

        if(trajet.getDestination()!=null){
            existingTrajet.setDestination(trajet.getDestination());
       }

       if(trajet.getStatut()!=null){
        existingTrajet.setStatut(trajet.getStatut());
   }

		return trajetRepository.save(existingTrajet);
    }

    public Trajet deleteTrajet(Integer id, Trajet trajet) {

        Trajet existingTrajet = this.trajetRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Trajet not found with id :" + id));
		 existingTrajet.setStatut(trajet.getStatut());
		 return trajetRepository.save(existingTrajet);
    }

    
    public List<Trajet> searchTrajet(String depart, String destination, Trajet trajet){
        
            List<Trajet> trajets = new ArrayList<>();
    
            trajetRepository.findByDepartAndDestination(depart, destination).forEach(trajets::add);
        
            return trajets;
        }
         
}