package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import projet.cflex.oda_cflex_smart_city1.Model.Demande;
import projet.cflex.oda_cflex_smart_city1.Service.DemandeService;
import projet.cflex.oda_cflex_smart_city1.exception.DemandeNotFoundException;

@RestController
@RequestMapping("/api")
/** Api demande
    * @author Yao Eloge
    */
public class DemandeController {
    DemandeService demandeService;
    @Autowired
    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }
    /** Optenir la liste des demandes
   * @return la liste des demandes
    */
    @GetMapping(value = "/demandes")
    public List<Demande> getAllDemandes() {
        return demandeService.getAllDemandes();
    }
    @GetMapping(value = "/demandes/{id}")
    public Demande getDemandeById(@PathVariable("id") @Min(1) int id) {
        Demande demande = demandeService.findById(id).
        orElseThrow(() -> new DemandeNotFoundException("Demande introuvable avec l'identifiant: " + id));
        return demande;
    }
    @PostMapping(value = "/demandes")
    public Demande createDemande(@Valid @RequestBody Demande demande) {
        return demandeService.save(demande);
    }
    @PutMapping(value = "/demandes/{id}")
    public Demande updateDemande(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Demande Newdemande) {
        Demande demande = demandeService.findById(id).
        orElseThrow(() -> new DemandeNotFoundException("Demande introuvable avec l'identifiant: " + id));
        demande.setLibelle(Newdemande.getLibelle());
        demande.setEtat(Newdemande.getEtat());
        demande.setProprietaire(Newdemande.getProprietaire());
        demande.setDate(Newdemande.getDate());
        demande.setStatut(Newdemande.getStatut());
        return demandeService.save(demande);
}
    @DeleteMapping(value = "/demandes/{id}")
    public String deleteDemande(@PathVariable("id") @Min(1) int id) {
        Demande demande = demandeService.findById(id).
        orElseThrow(() -> new DemandeNotFoundException("Demande introuvable avec l'identifiant: " + id));
        demandeService.deleteById(id);
        return "Demande avec l'ID :"+id+" supprimée succès";
}
}