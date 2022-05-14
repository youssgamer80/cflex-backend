package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "L'API de Demande", description = "L'Api de la gestion des demande")
/**
 * Api demande
 * @author Yao Eloge
 */
public class DemandeController {
    DemandeService demandeService;

    /**
     * DemandeController
     * @param demandeService
     */
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

    /** Obtenir une une demande avec l'id passe en param
     * @param id
     * @return la liste des demandes
     */
    @GetMapping(value = "/demandes/{id}")
    public Demande getDemandeById(@PathVariable("id") @Min(1) int id) {
        Demande demande = demandeService.findById(id).
                orElseThrow(() -> new DemandeNotFoundException("Demande introuvable avec l'identifiant: " + id));
        return demande;
    }

    /** Ajouter une nouvelle demande
     * @param input
     * @return message
     */
    @PostMapping(value = "/demandes")
    public String createDemande(@Valid @RequestBody @NotNull DemandeObject input) {
        Demande demande = new Demande();
        saveDemande(input, demande);
        return "Demande cree avec succes";
    }

    /**
     *  Procedure pour gerer l'enregistrement d'une demande
     * @param input
     * @param demande
     */
    private void saveDemande(@RequestBody @Valid @NotNull DemandeObject input, Demande demande) {
        demande.setCodeDemande(input.getCodeDemande());
        demande.setEtat(input.getEtat());
        demande.setIdProprietaireFk(input.getProprietaireId());
        demande.setDate(input.getDate());
        demande.setStatut(input.getStatus());
        demande.setIdTypeTransportFk(input.getTypeTransportId());
        demande.setIdZoneFk(input.getZoneId());
        demandeService.save(demande);
    }


    /**
     * Editer une demande
     *
     * @param input
     * @return message
     */
    @PutMapping(value = "/demandes/{id}")
    public String updateDemande(@PathVariable("id") @Min(1) int id, @Valid @RequestBody DemandeObject input) {
        Demande demande = demandeService.findById(id).
                orElseThrow(() -> new DemandeNotFoundException("Demande introuvable avec l'identifiant: " + id));
        saveDemande(input, demande);
        return "Demande editer avec succes";
    }

    /**
     * Supprimer une demande
     *
     * @param id
     * @return message
     */
    @DeleteMapping(value = "/demandes/{id}")
    public String deleteDemande(@PathVariable("id") @Min(1) int id) {
        Demande demande = demandeService.findById(id).
                orElseThrow(() -> new DemandeNotFoundException("Demande introuvable avec l'identifiant: " + id));
        demandeService.deleteById(id);
        return "Demande avec l'ID :"+id+" supprimée succès";
    }
}
