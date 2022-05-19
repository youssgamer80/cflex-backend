package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import projet.cflex.oda_cflex_smart_city1.Model.PointArret;
import projet.cflex.oda_cflex_smart_city1.Repository.PointArretRepository;
import projet.cflex.oda_cflex_smart_city1.Service.PointArretService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController
@RequestMapping("/api/v1/PointArret")

@Tag(name = "L'API de Point d'arrêt", description = "L'Api de la gestion des points d'arrêts")
public class PointArretController {

    @Autowired
    private PointArretService pointarretservice;
 
    @Autowired
    PointArretRepository pointarretrepo;

    /** Optenir la liste des points d'arrêts
     * @return la liste des points d'arrêts
     */

    @GetMapping("/getPointArrets")
    public ResponseEntity<Object> ListePointArret(){
        try {
            List<PointArret> resultat = pointarretservice.Liste();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, resultat);      
        } 
        catch (Exception e) 
        {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
        
    }


     /** Obtenir un point d'arrêt avec l'id passé en paramètre
     * @param id
     * @return un point d'arrêt
     */

    @GetMapping("/getPointArretById/{id}")
    @ResponseBody
    public Object OnePoint(@Validated @PathVariable("id") Integer id){

        try {
            PointArret unpointarret = pointarretservice.PointById(id).orElseThrow(() -> new IllegalArgumentException("Id invalide" + id));
            return unpointarret;
        } 
        catch (Exception e) {
            return ("Le véhicule avec l'Id:"+id+" n'existe pas");
        }

    }


    
}
