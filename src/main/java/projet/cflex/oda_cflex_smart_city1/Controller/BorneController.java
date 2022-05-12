package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import projet.cflex.oda_cflex_smart_city1.Service.BorneService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;
import projet.cflex.oda_cflex_smart_city1.Model.Borne;

@RestController
@RequestMapping("api/bornes")
public class BorneController {

    @Autowired
    private BorneService borneService;

    // @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping
    public ResponseEntity<Object> Get() {
        try {
            List<Borne> result = borneService.getAllBornes();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> Get(@PathVariable int id) {
        try {
            Borne result = borneService.getBorne(id);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @PostMapping(value = "/addBorne")
    public ResponseEntity<Object> Post(@RequestBody Borne borne) {
        try {
            Borne result = borneService.addBorne(borne);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    
    @DeleteMapping(value = "/deleteBorne/{id}")
    public ResponseEntity<Object> Put(@PathVariable Integer id, @RequestBody Borne borne) {

        try {
            Borne result = borneService.deleteBorne(id, borne);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }
    

    @PutMapping(value = "/updateBorne/{id}")
    public ResponseEntity<Object> Put(@RequestBody Borne borne, @PathVariable Integer id) {
        
        try{
            Borne result = borneService.updateBorne(borne, id);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }
    
    }
}
