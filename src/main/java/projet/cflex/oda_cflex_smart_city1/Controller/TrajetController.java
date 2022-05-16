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
import projet.cflex.oda_cflex_smart_city1.Model.Trajet;
import projet.cflex.oda_cflex_smart_city1.Service.TrajetService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController // This means that this class is a Controller
@RequestMapping("/api/trajets")

@Tag(name = "API Trajet", description = "Api des services Trajet")
public class TrajetController {

    @Autowired
    private TrajetService trajetService;
    @GetMapping
        public ResponseEntity<Object> Get() {
            try {
                List<Trajet> result = trajetService.getAllTrajets();
                return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

        @GetMapping(value="/{id}")
        public ResponseEntity<Object> Get(@PathVariable int id) {
            try {
                Trajet result = trajetService.getTrajet(id);
                return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }


    @PostMapping(value = "/addTrajet")
    public ResponseEntity<Object> Post(@RequestBody Trajet trajet) {
        try {
            Trajet result = trajetService.addTrajet(trajet);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @PutMapping(value = "/updateTrajet/{id}")
    public ResponseEntity<Object> Put(@RequestBody Trajet trajet, @PathVariable Integer id) {
        
        try{
            Trajet result = trajetService.updateTrajet(id, trajet);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }
    
    }

    @DeleteMapping(value = "/deleteTrajet/{id}")
    public ResponseEntity<Object> Put( @PathVariable Integer id, @RequestBody Trajet trajet) {
       
        try{
            Trajet result = trajetService.deleteTrajet(id,trajet);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, result);
        } catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }

    @GetMapping(value="/searchTrajet/{depart}/{destination}")
        public ResponseEntity<Object> Get(@PathVariable String depart, @PathVariable String destination, Trajet trajet) {
            try {
                List<Trajet> result = trajetService.searchTrajet(depart, destination, trajet);
                return ResponseHandler.generateResponse("Trajet found!", HttpStatus.OK, result);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

}

