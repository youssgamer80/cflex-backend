package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import projet.cflex.oda_cflex_smart_city1.Model.Litige;
import projet.cflex.oda_cflex_smart_city1.Service.LitigeService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/api/litiges")
public class LitigeController {

    @Autowired
    private LitigeService litigeService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Get() {
        try {
            List<Litige> result = litigeService.getAllLitige();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

   

    @GetMapping(value = "/ByUsager/{idUsager}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> GetByUsager(@PathVariable Integer idUsager) {
        try {

            List<Litige> result = litigeService.getByUsager(idUsager);
            return ResponseHandler.generateResponse("Successfully retrieved data!",
                    HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(),
                    HttpStatus.MULTI_STATUS, null);
        }
    }



    @PostMapping(value = "/addLitige")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Post(@RequestBody LitigeObject litigeObject) {
        try {

            Litige result = litigeService.addLitige(litigeObject);
            // Ligne result = null;
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    // @PutMapping(value = "/updateligne/")
    // public ResponseEntity<Object> Put(@RequestBody Ligne_Point_ArretObject ligne_Point_ArretObject) {

    //     try {
    //         String result;
    //         String message ;
    //         if(ligne_Point_ArretObject.idPointArretFk.length>0){
    //             result = litigeService.updateLigne_Point_Arrets(ligne_Point_ArretObject);
    //             message="Successfully deleted data!";
    //         }
    //         else{
    //             result = null;
    //             message="Problème rencontré";
    //         }
            
    //         // System.out.println(result);
    //         return ResponseHandler.generateResponse(message,
    //                 HttpStatus.OK, result);
    //     } catch (Exception e) {
    //         return ResponseHandler.generateResponse(e.getMessage(),
    //                 HttpStatus.MULTI_STATUS);
    //     }
    // }

}
