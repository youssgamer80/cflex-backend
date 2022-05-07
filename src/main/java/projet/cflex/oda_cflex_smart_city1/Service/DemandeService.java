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
    private Integer id;

    public List<Demande> getAllDemandes() {
        
        List<Demande> demandes = new ArrayList<>();

        demandeRepository.findAll().forEach(demandes::add);

        return demandes;
    }
    
    public Demande addDemande(Demande demande) {

        return demandeRepository.save(demande);
    }

    public Demande getDemande() {

        return this.demandeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Demande not found with id :" + id));
    }

    public Demande updateDemande(Integer id, Demande demande) {

        Demande existingDemande = this.demandeRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Demande not found with id :" + id));
		 existingDemande.setLibelle(Demande.getLibelle());
		 existingDemande.setEtat(demande.getEtat());
		 existingDemande.setIdProprietaireFk(demande.getIdProprietaireFk());
		 existingDemande.setDate(demande.getDate());
		 existingDemande.setNom(demande.getNom());
		 existingDemande.setPrenom(demande.getPrenom());
		 existingDemande.setLieuResidence(demande.getLieuResidence());
		 existingDemande.setTelephone(demande.getTelephone());
		 existingDemande.setEmail(demande.getEmail());
		 existingDemande.setMarque(demande.getMarque());
		 existingDemande.setCni(demande.getCni());
		 existingDemande.setPermis(demande.getPermis());
		 existingDemande.setCarteGrise(demande.getCarteGrise());
		 existingDemande.setAssurance(demande.getAssurance());
		 existingDemande.setImmatriculation(demande.getImmatriculation());
		 existingDemande.setModele(demande.getModele());
		 existingDemande.setIdTypeTransportFk(demande.getIdTypeTransportFk());
		 existingDemande.setNbrePlace(demande.getNbrePlace());
		 existingDemande.setZoneFk(demande.getZoneFk());
		 existingDemande.setIdTypeTransportFk(demande.getIdTypeTransportFk());
		 return demandeRepository.save(existingDemande);
    }

    public Demande deleteDemande(Integer id) {

        Demande existingDemande = this.demandeRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Demande not found with id :" + id));
		 existingDemande.setLibelle(Demande.getLibelle());
		 return demandeRepository.save(existingDemande);
    }

}