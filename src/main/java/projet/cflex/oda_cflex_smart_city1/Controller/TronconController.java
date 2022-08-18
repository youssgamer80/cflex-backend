package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import projet.cflex.oda_cflex_smart_city1.Model.Ligne_PointArret;
import projet.cflex.oda_cflex_smart_city1.Model.Troncon;
import projet.cflex.oda_cflex_smart_city1.Repository.TronconRepository;
import projet.cflex.oda_cflex_smart_city1.Service.TronconService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;
import projet.cflex.oda_cflex_smart_city1.Service.TronconService;


@RestController // This means that this class is a Controller
@RequestMapping("/api/v1/Troncon")
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@Tag(name = "API Troncon", description = "Api des services troncon")
public class TronconController {

    @Autowired
    private TronconService tronconServ;
    @Autowired
    private TronconRepository tronconRepo;


    /** Optenir la liste des tronçons
     * @return la liste des tronçons
     */

    @GetMapping("/getTroncons")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> ListeTroncon(){
        try {
            List<Troncon> resultat = tronconServ.Liste();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, resultat);      
        } 
        catch (Exception e) 
        {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
        
    }

    /** Obtenir un tronçon avec l'id passé en paramètre
     * @param id
     * @return un tronçon
     */

    @GetMapping("/getTronconById/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    @ResponseBody
    public ResponseEntity<Object> UnMode(@Validated @PathVariable("id") Integer id){

        try {

            Troncon untroncon = tronconServ.TronconById(id).orElseThrow(() -> new IllegalArgumentException("Id invalide" + id));
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, untroncon);
        } 
        catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

    /** Obtenir des tronçons avec le nom passé en paramètre
     * @param nom
     * @return tronçons
     */

    @GetMapping(value="/getTronconByNom/{nom}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    @ResponseBody
    public ResponseEntity<Object> ListeMode(@Validated @PathVariable String nom){

        try {

            List<Troncon> troncons = tronconServ.TronconByNom(nom);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, troncons);
        } 
        catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

    /** Générer de nouveaux tronçons
     * @param ligne_pointarrets
     * @return les tronçons ajoutés
     */

    @PostMapping("/addTronconGenere")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Create(@RequestBody Ligne_PointArret Ligne_PointArrets) {
        try {
            List<Troncon> resultat = tronconServ.Generatetroncon(Ligne_PointArrets);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, resultat);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    /**
     * Modifier un tronçon
     * @param id
     * @return le tronçon modifié
     */

    @PutMapping("/updateTroncon/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Put(@RequestBody Troncon troncon, @PathVariable Integer id) {
        
        try{
            Troncon result = tronconServ.updateTroncon(id, troncon);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }
    
    }


    /** Supprimer un tronçon avec l'id passé en paramètre
     * @param id
     * @return le tronçon supprimé
     */

    @DeleteMapping("/deleteTroncon/{nom}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Delete( @Validated @PathVariable String nom){
        try {
            List<Troncon> resultat = tronconServ.deleteTroncon(nom);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, resultat);
        } 
        catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    } 
       

    
}
