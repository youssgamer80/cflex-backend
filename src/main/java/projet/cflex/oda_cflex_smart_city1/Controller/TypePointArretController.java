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
import projet.cflex.oda_cflex_smart_city1.Model.TypePointArret; 
import projet.cflex.oda_cflex_smart_city1.Service.TypePointArretService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/api/v1/TypePointArret")

@Tag(name = "L'API de Type de point d'arret", description = "L'Api de la gestion des Types de point d'arrêt")
public class TypePointArretController {

    @Autowired
    private TypePointArretService service;

    /** Optenir la liste des Types de point d arrêt
     * @return la liste des Types de point d arrêt
     */

    @GetMapping("/getTypePointArrets")
    public ResponseEntity<Object> ListeTypesPointArret(){
        try {
            List<TypePointArret> resultat = service.Liste();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, resultat);      
        } 
        catch (Exception e) 
        {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
        
    }

     /** Obtenir un Type de point d arrêt avec l'id passé en paramètre
     * @param id
     * @return un Type de point d arrêt
     */

    @GetMapping("/getTypePointArretById/{id}")
    @ResponseBody
    public Object UnType(@Validated @PathVariable("id") Integer id){

        try {
            TypePointArret un_type = service.TypePAById(id).orElseThrow(() -> new IllegalArgumentException("Id invalide" + id));
            return un_type;
        } 
        catch (Exception e) {
            return ("Le type de point d'arrêt avec l'Id:"+id+" n'existe pas");
        }

    }


    /** Ajouter un nouveau Type de point d arrêt
     * @param pointdarret
     * @return le Type de point d arrêt ajouté
     */


    @PostMapping("/addTypePointArret")
    public ResponseEntity<Object> AddTypePA (@RequestBody TypePointArret type){
        try {
            TypePointArret resultat = service.NewTypePA(type);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, resultat);
        } 
        catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    /**
     * Modifier un Type de point d arrêt
     * @param id
     * @return le Type de point d arrêt modifié
     */

    @PutMapping("/updateTypePointArret/{id}")
    public ResponseEntity<Object> updateTypePA(@PathVariable("id") Integer id, @RequestBody TypePointArret mode){
        try{
            TypePointArret resultat= service.updateTypePA(id,mode);
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

    @DeleteMapping("/deleteTypePointArret/{id}")
    public ResponseEntity<Object> Delete( @Validated @PathVariable Integer id){
        try {
            TypePointArret resultat = service.deleteTypePA(id);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, resultat);
        } 
        catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
              
    }

    
}
