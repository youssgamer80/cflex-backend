package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import projet.cflex.oda_cflex_smart_city1.Model.ModeDeplacement;
import projet.cflex.oda_cflex_smart_city1.Repository.ModeDeplacementRepository;
import projet.cflex.oda_cflex_smart_city1.Service.ModeDeplacementService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/api/v1/ModeDeplacement")

@Tag(name = "L'API de Mode de déplacement", description = "L'Api de la gestion des modes de déplacement")
public class ModeDeplacementController {

    @Autowired
    private ModeDeplacementService MDService;
    @Autowired
    private ModeDeplacementRepository repo;

    /** Optenir la liste des modes de déplacements
     * @return la liste des modes de déplacements
     */

    @GetMapping("/getModeDeplacements")
    public ResponseEntity<Object> ListeModeDeplacement(){
        try {
            List<ModeDeplacement> resultat = MDService.Liste();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, resultat);      
        } 
        catch (Exception e) 
        {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
        
    }

     /** Obtenir un mode de déplacement avec l'id passé en paramètre
     * @param id
     * @return un mode de déplacement
     */

    @GetMapping("/getModeDeplacementById/{id}")
    @ResponseBody
    public Object UnMode(@Validated @PathVariable("id") Integer id){

        try {
            ModeDeplacement unmode = MDService.ModeById(id).orElseThrow(() -> new IllegalArgumentException("Id invalide" + id));
            return unmode;
        } 
        catch (Exception e) {
            return ("Le mode de déplacement avec l'Id:"+id+" n'existe pas");
        }

    }


    /** Obtenir des modes de déplacement avec le nom passé en paramètre
     * @param nom
     * @return un point d'arrêt
     */

    @GetMapping("/getModeDeplacementByMode/{modeDeplacement}")
    @ResponseBody
    public ResponseEntity<Object> ListeMode(@Validated @PathVariable("modeDeplacement") String modeDeplacement){

        try {

            List<ModeDeplacement> modes = MDService.ModesByLibelle(modeDeplacement);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, modes);
        } 
        catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

    /** Ajouter un nouveau mode de déplacement
     * @param pointdarret
     * @return le mode de déplacement ajouté
     */


    @PostMapping("/addModeDeplacement")
    public ResponseEntity<Object> Post (@RequestBody ModeDeplacement mode){
        try {
            ModeDeplacement resultat = MDService.NewMode(mode);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, resultat);
        } 
        catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

        /**
     * Modifier un mode de déplacement
     * @param id
     * @return le ode de déplacement modifié
     */

    @PutMapping("/updateModeDeplacement/{id}")
    public ResponseEntity<Object> updateMode(@PathVariable("id") Integer id, @RequestBody ModeDeplacement mode){
        try{
            ModeDeplacement resultat= MDService.updateModeDeplacement(id,mode);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, resultat);
        }
        catch (Exception e) {
            
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }
    }

        /**
     * Supprimer un mode de déplacement
     * @param id
     * @return le mode de déplacelent supprimé
     */

    @DeleteMapping("/deleteModeDeplacement/{id}")
    public ResponseEntity<Object> Delete( @Validated @PathVariable Integer id){
        try {
            ModeDeplacement resultat = MDService.deleteMode(id);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, resultat);
        } 
        catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
              
    }

    
}
