package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Demande;
import projet.cflex.oda_cflex_smart_city1.Repository.DemandeRepository;

@Service
public class DemandeService {

    @Autowired
    public DemandeRepository demandeRepository;
    private Boolean statut=true;
    public Demande demande;


    public List<Demande> getAllDemandes() {
        
        List<Demande> demandes = new ArrayList<>();

        demandeRepository.findByStatutJPQL(statut).forEach(demandes::add);

        return demandes;
    }
    
    public Demande addDemande(Demande demande) {

        return demandeRepository.save(demande);
    }

    public Demande getDemande(int id) {

        return this.demandeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Demande not found with id :" + id));
    }

    public Demande updateDemande(Integer id, Demande demande) {

        Demande existingDemande = this.demandeRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Demande not found with id :" + id));
        if(demande.getEtat()!=null){
             existingDemande.setEtat(demande.getEtat());
        }

		if(demande.getIdProprietaireFk()!=null){
             existingDemande.setIdProprietaireFk(demande.getIdProprietaireFk());
       }

       if(demande.getDate()!=null){
        existingDemande.setDate(demande.getDate());
       }

       if(demande.getStatut()!=null){
        existingDemande.setStatut(demande.getStatut());
   }

    if(demande.getImmatriculation()!=null){
            existingDemande.setImmatriculation(demande.getImmatriculation());
    }

    if(demande.getMarque()!=null){
        existingDemande.setMarque(demande.getMarque());
    }

    if(demande.getNbPlace()!=null){
        existingDemande.setNbPlace(demande.getNbPlace());
    }

    if(demande.getIdTypeTransportFk()!=null){
        existingDemande.setIdTypeTransportFk(demande.getIdTypeTransportFk());
    }

    if(demande.getIdZoneFk()!=null){
        existingDemande.setIdZoneFk(demande.getIdZoneFk());
    }

    if(demande.getModel()!=null){
        existingDemande.setModel(demande.getModel());
    }

            return demandeRepository.save(existingDemande);
        }

    public Demande deleteDemande(Integer id, Demande demande) {

        Demande existingDemande = this.demandeRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Demande not found with id :" + id));
		 existingDemande.setStatut(demande.getStatut());
		 return demandeRepository.save(existingDemande);
    }
    

}