package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import projet.cflex.oda_cflex_smart_city1.Model.Zoneparent;
import projet.cflex.oda_cflex_smart_city1.Service.ZoneparentService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/api/zoneparents")
@Tag(name = "API Zone parent", description = "Api des services des parent des zones")
public class ZoneparentController {

    @Autowired
    private ZoneparentService zoneparentService;
    @GetMapping
        public ResponseEntity<Object> Get() {
            try {
                List<Zoneparent> result = zoneparentService.getAllZoneparents();
                return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

        @GetMapping(value="/{id}")
        public ResponseEntity<Object> Get(@PathVariable int id) {
            try {
                Zoneparent result = zoneparentService.getZoneparent(id);
                return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }


    @PostMapping(value = "/addZoneparent")
    public ResponseEntity<Object> Post(@RequestBody Zoneparent zoneparent) {
        try {
            Zoneparent result = zoneparentService.addZoneparent(zoneparent);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
 
    
    @PutMapping(value = "/updateZoneparent/{id}")
    public ResponseEntity<Object> Put(@RequestBody Zoneparent zoneparent, @PathVariable Integer id) {
        
        try{
            Zoneparent result = zoneparentService.updateZoneparent(id, zoneparent);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }
    
    }

    @DeleteMapping(value = "/deleteZoneparent/{id}")
    public ResponseEntity<Object> Put( @PathVariable Integer id, @RequestBody Zoneparent zoneparent) {
       
        try{
            Zoneparent result = zoneparentService.deleteZoneparent(id,zoneparent);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, result);
        } catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }


}