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

import projet.cflex.oda_cflex_smart_city1.Model.Ligne;
import projet.cflex.oda_cflex_smart_city1.Service.LigneService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/api/lignes")
public class LigneController {

    @Autowired
    private LigneService ligneService;

    @GetMapping
    public ResponseEntity<Object> Get() {
        try {
            List<Ligne> result = ligneService.getAllLignes();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping(value="byid/{id}")
    public ResponseEntity<Object> Get(@PathVariable int id) {
    try {
    Ligne result = ligneService.getLigneBydId(id);
    return ResponseHandler.generateResponse("Successfully retrieved data!",
    HttpStatus.OK, result);
    } catch (Exception e) {
    return ResponseHandler.generateResponse(e.getMessage(),
    HttpStatus.MULTI_STATUS, null);
    }
    }

    @GetMapping(value ="/{nomLigne}")
    public ResponseEntity<Object> Get(@PathVariable String nomLigne) {
        try {
            
            Ligne result = ligneService.getLigne(nomLigne);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping(value = "/addLigne")
    public ResponseEntity<Object> Post(@RequestBody LigneObject ligneObject) {
        try {
            // System.out.print(ligneObject);
        //     System.out.print("LIGNE OBJECT ");
        // System.out.print(ligneObject.nom);
        // System.out.print(ligneObject.depart);
        // System.out.print(ligneObject.arrivee);

            Ligne result = ligneService.addLigne(ligneObject);
            // Ligne result = null;
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping(value = "/updateligne/{id}")
    public ResponseEntity<Object> Put(@RequestBody LigneObject ligneObject, @PathVariable Integer id) {

        try {
            Ligne result = ligneService.updateLigne(id, ligneObject);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }

    }

    @DeleteMapping(value = "/deleteligne/{id}")
    public ResponseEntity<Object> Put(@PathVariable Integer id) {

        try {
            Ligne result = ligneService.deleteLigne(id);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }

}
