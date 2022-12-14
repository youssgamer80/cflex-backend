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
import projet.cflex.oda_cflex_smart_city1.Model.Itineraire;
import projet.cflex.oda_cflex_smart_city1.Service.ItineraireService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController // This means that this class is a Controller
@RequestMapping("/api/itineraires")
@Tag(name = "API Itineraire", description = "Api services itineraire")
public class ItineraireController {

    @Autowired
    private ItineraireService itineraireService;
    @GetMapping
        public ResponseEntity<Object> Get() {
            try {
                List<Itineraire> result = itineraireService.getAllItineraires();
                return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

        @GetMapping(value="/{id}")
        public ResponseEntity<Object> Get(@PathVariable int id) {
            try {
                Itineraire result = itineraireService.getItineraire(id);
                return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }


    @PostMapping(value = "/addItineraire")
    public ResponseEntity<Object> Post(@RequestBody Itineraire itineraire) {
        try {
            Itineraire result = itineraireService.addItineraire(itineraire);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
 
    
    @PutMapping(value = "/updateItineraire/{id}")
    public ResponseEntity<Object> Put(@RequestBody Itineraire itineraire, @PathVariable Integer id) {
        
        try{
            Itineraire result = itineraireService.updateItineraire(id, itineraire);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }
    
    }

    @DeleteMapping(value = "/deleteUsager/{id}")
    public ResponseEntity<Object> Put( @PathVariable Integer id, @RequestBody Itineraire itineraire) {
       
        try{
            Itineraire result = itineraireService.deleteItineraire(id,itineraire);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, result);
        } catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }


}