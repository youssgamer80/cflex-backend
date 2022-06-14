package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import javax.validation.constraints.Null;

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

import projet.cflex.oda_cflex_smart_city1.Model.Borne;
import projet.cflex.oda_cflex_smart_city1.Service.BorneService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/api/bornes")
public class BorneController {

    @Autowired
    private BorneService borneService;

    @GetMapping
    public ResponseEntity<Object> Get() {
        try {
            List<Borne> result = borneService.getAllBornes();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping(value = "byid/{id}")
    public ResponseEntity<Object> Get(@PathVariable int id) {
        try {
            Borne result = borneService.getBorneBydId(id);
            return ResponseHandler.generateResponse("Successfully retrieved data!",
                    HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(),
                    HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping(value = "/{nomBorne}")
    public ResponseEntity<Object> Get(@PathVariable String nomBorne) {
        try {

            Borne result = borneService.getBorne(nomBorne);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping(value = "/addBorne")
    public ResponseEntity<Object> Post(@RequestBody BorneObject BorneObject) {
        try {
            // System.out.print(BorneObject);
            // System.out.print("Borne OBJECT ");
            // System.out.print(BorneObject.nom);
            // System.out.print(BorneObject.depart);
            // System.out.print(BorneObject.arrivee);

            Borne result = borneService.addBorne(BorneObject);
            // Borne result = null;
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping(value = "/updateBorne/{id}")
    public ResponseEntity<Object> Put(@RequestBody BorneObject BorneObject, @PathVariable Integer id) {

        try {
            Borne result = borneService.updateBorne(id, BorneObject);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }

    }

    @DeleteMapping(value = "/deleteBorne/{id}")
    public ResponseEntity<Object> Put(@PathVariable Integer id) {

        try {
            Borne result = borneService.deleteBorne(id);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }

}
