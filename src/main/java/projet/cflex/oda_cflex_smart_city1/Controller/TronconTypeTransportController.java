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

import projet.cflex.oda_cflex_smart_city1.Model.TronconTypeTransport;
import projet.cflex.oda_cflex_smart_city1.Service.TronconTypeTransportService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/troncontypetransport")
public class TronconTypeTransportController {

    @Autowired
    private TronconTypeTransportService tronconTypeTransportService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Get() {
        try {
            List<TronconTypeTransport> result = tronconTypeTransportService.getAllTronconTypeTransports();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @PostMapping("/addTronconTypeTransport")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Post(@RequestBody TronconTypeTransportObject tronconTypeTransportObject){

        try{

            TronconTypeTransport result = tronconTypeTransportService.addTronconTypeTransport(tronconTypeTransportObject);
            // Ligne result = null;
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        }
        catch(Exception e){

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

   

    

}
