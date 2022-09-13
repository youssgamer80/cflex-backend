package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
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

import projet.cflex.oda_cflex_smart_city1.Model.Ligne;
import projet.cflex.oda_cflex_smart_city1.Model.Troncon;
import projet.cflex.oda_cflex_smart_city1.Repository.TronconRepository;
import projet.cflex.oda_cflex_smart_city1.Service.LigneService;
import projet.cflex.oda_cflex_smart_city1.Service.TronconService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/rechercher-itineraire")
public class RechercherItineraireController {
   @Autowired
   private TronconService tronconServ;
   @Autowired
   private TronconRepository tronconRepo;

   // private double longitude= ;
   // private double latitude;

   /**
    * Optenir la liste des tronçons
    * 
    * @return la liste des tronçons
    */

   @GetMapping("/getTroncons")
   @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
   public ResponseEntity<Object> ListeTroncon() {
      try {
         List<Troncon> resultat = tronconServ.Liste();
         return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, resultat);
      } catch (Exception e) {
         return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
      }

   }

}