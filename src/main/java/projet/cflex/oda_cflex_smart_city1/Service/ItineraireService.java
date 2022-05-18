package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Itineraire;
import projet.cflex.oda_cflex_smart_city1.Repository.ItineraireRepository;

@Service
public class ItineraireService {

    @Autowired
    public ItineraireRepository itineraireRepository;
    private Boolean statut=true;
    public Itineraire itineraire;


    public List<Itineraire> getAllItineraires() {
        
        List<Itineraire> itineraires = new ArrayList<>();

        itineraireRepository.findByStatutJPQL(statut).forEach(itineraires::add);

        return itineraires;
    }
    
    public Itineraire addItineraire(Itineraire itineraire) {

        return itineraireRepository.save(itineraire);
    }

    public Itineraire getItineraire(int id) {

        return this.itineraireRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Itineraire not found with id :" + id));
    }

    public Itineraire updateItineraire(Integer id, Itineraire itineraire) {

        Itineraire existingItineraire = this.itineraireRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Itineraire not found with id :" + id));
        if(itineraire.getTemps()!=null){
             existingItineraire.setTemps(itineraire.getTemps());
        }

		if(itineraire.getTarif()!=null){
             existingItineraire.setTarif(itineraire.getTarif());
       }

       if(itineraire.getDistance()!=null){
        existingItineraire.setDistance(itineraire.getDistance());
       }
       if(itineraire.getIdTrajetFk()!=null){
           existingItineraire .setIdTrajetFk((itineraire.getIdTrajetFk()));
       }
       if(itineraire.getStatut()!=null){
        existingItineraire.setStatut(itineraire.getStatut());
   }

		return itineraireRepository.save(existingItineraire);
    }

    public Itineraire deleteItineraire(Integer id, Itineraire itineraire) {

        Itineraire existingItineraire = this.itineraireRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Itineraire not found with id :" + id));
		 existingItineraire.setStatut(itineraire.getStatut());
		 return itineraireRepository.save(existingItineraire);
    }
    

}