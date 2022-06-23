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

import projet.cflex.oda_cflex_smart_city1.Model.Ligne_Point_Arret;
import projet.cflex.oda_cflex_smart_city1.Service.Ligne_Point_ArretService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/api/lignespointarret")
public class Ligne_Point_ArretController {

    @Autowired
    private Ligne_Point_ArretService ligne_Point_ArretService;

    @GetMapping
    public ResponseEntity<Object> Get() {
        try {
            List<Ligne_Point_Arret> result = ligne_Point_ArretService.getAllLignesPointArret();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

   

    @GetMapping(value = "/{idligne}")
    public ResponseEntity<Object> Get(@PathVariable Integer idligne) {
        try {

            List<Ligne_Point_Arret> result = ligne_Point_ArretService.getByIdLigne(idligne);
            return ResponseHandler.generateResponse("Successfully retrieved data!",
                    HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(),
                    HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping(value = "/addLignePointArret")
    public ResponseEntity<Object> Post(@RequestBody Ligne_Point_ArretObject ligne_Point_ArretObject) {
        try {

            Ligne_Point_Arret result = ligne_Point_ArretService.addLignePointArret(ligne_Point_ArretObject);
            // Ligne result = null;
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @PutMapping(value = "/updateligne/")
    public ResponseEntity<Object> Put(@RequestBody Ligne_Point_ArretObject ligne_Point_ArretObject) {

        try {
            String result = ligne_Point_ArretService.deleteLigne_Point_Arrets(ligne_Point_ArretObject);
            // System.out.println(result);
            return ResponseHandler.generateResponse("Successfully deleted data!",
                    HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(),
                    HttpStatus.MULTI_STATUS);
        }
    }

}
