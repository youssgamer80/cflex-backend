package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import projet.cflex.oda_cflex_smart_city1.Model.Demande;
import projet.cflex.oda_cflex_smart_city1.Service.DemandeService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController // This means that this class is a Controller
@RequestMapping("/api/demandes")
/**
 *le controller de l'entité demande
  */
  @Tag(name = "L'API de Demande", description = "L'Api de la gestion des demande")
public class DemandeController {

    @Autowired
    private DemandeService demandeService;
    @GetMapping
   /** Optenir la liste des demandes
   * @return la liste des demandes
    */
        public ResponseEntity<Object> Get() {
            try {
                List<Demande> result = demandeService.getAllDemandes();
                return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

        @GetMapping(value="/{id}")
          /** Optenir les informations d'une demande
   * @return les informations d'une demande
    */
        public ResponseEntity<Object> Get(@PathVariable int id) {
            try {
                Demande result = demandeService.getDemande();
                return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

    @PostMapping(value = "/addDemande")
      /** Faire l'enregistrement d'une demande
   * @return l'ajout d'une demande
    */
    public ResponseEntity<Object> Post(@RequestBody Demande demande) {
        try {
            Demande result = demandeService.addDemande(demande);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping(value = "/updateDemande/{id}")
      /** Faire la mise à jour d'une demande
   * @return la modification d'une demande
    */
    public ResponseEntity<Object> Put(@RequestBody Demande demande, @PathVariable Integer id) {
        
        try{
            Demande result = demandeService.updateDemande(id, demande);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }
    
    }

    @DeleteMapping(value = "/deleteDemande/{id}")
        /** Faire la suppression d'une demande
   * @return la suppression d'une demande
    */    
    public ResponseEntity<Object> Delete(@PathVariable Integer id, Demande demande) {
       
        try{

            Demande result = demandeService.deleteDemande(id);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, result);
        } catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }


}