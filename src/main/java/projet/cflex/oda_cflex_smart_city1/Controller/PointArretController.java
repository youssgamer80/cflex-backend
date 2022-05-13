package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import projet.cflex.oda_cflex_smart_city1.Model.PointArret;
import projet.cflex.oda_cflex_smart_city1.Repository.PointArretRepository;
import projet.cflex.oda_cflex_smart_city1.Service.PointArretService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController
@RequestMapping("/api/PointArret")
public class PointArretController {

    @Autowired
    private PointArretService pointarretservice;
 
    @Autowired
    PointArretRepository pointarretrepo;



    @GetMapping("/Liste")
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

    @GetMapping("/{id}")
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


    @PostMapping("/add")

    public ResponseEntity<Object> Post(@RequestBody PointArret pointdarret) {
        try {
            PointArret result = (PointArret) pointarretservice.NewPointArret(pointdarret);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updatePointArret(@PathVariable("id") Integer id, @Validated PointArret pointdarret){
        try{
            PointArret resultat= pointarretservice.updatePointArret(id,pointdarret);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, resultat);
        }
        catch (Exception e) {
            
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> Put( @Validated @PathVariable Integer id, PointArret pointdarret){
        try {
            PointArret resultat = pointarretservice.deletePointArret(id, pointdarret);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, resultat);
        } 
        catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
              
    }


    
}
