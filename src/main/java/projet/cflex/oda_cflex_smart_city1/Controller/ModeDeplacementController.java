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
import projet.cflex.oda_cflex_smart_city1.Model.ModeDeplacement;
import projet.cflex.oda_cflex_smart_city1.Service.ModeDeplacementService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController
@RequestMapping("/api/modedeplacement")
public class ModeDeplacementController {

    @Autowired
    private ModeDeplacementService repository;
    private ModeDeplacementService MDService;
    

    @GetMapping("/Liste")
    public ResponseEntity<Object> ListePointArret(){
        try {
            List<ModeDeplacement> resultat = MDService.Listemodes();
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
            ModeDeplacement unmodedeplacement = MDService.ModeById(id).orElseThrow(() -> new IllegalArgumentException("Id invalide" + id));
            return unmodedeplacement;
        } 
        catch (Exception e) {
            return ("Le mode de déplacement avec l'Id:"+id+" n'existe pas");
        }

    }

    @PostMapping("/add")
    public ResponseEntity<Object> Post(@RequestBody ModeDeplacement modedeplacement) {
        try {
            ModeDeplacement result = MDService.AddMode(modedeplacement);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updatePointArret(@PathVariable("id") Integer id, @Validated ModeDeplacement modedeplacement){
        try{
            ModeDeplacement resultat= MDService.UpdateMode(id,modedeplacement);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, resultat);
        }
        catch (Exception e) {
            
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> Put( @Validated @PathVariable Integer id, ModeDeplacement modedeplacement){
        try {
            ModeDeplacement resultat = MDService.DeleteMode(id, modedeplacement);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, resultat);
        } 
        catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
              
    }
}

