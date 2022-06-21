package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import projet.cflex.oda_cflex_smart_city1.Model.TronconTypeTransport;
import projet.cflex.oda_cflex_smart_city1.Service.TronconTypeTransportService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/api/troncon_typetransport")
@Tag(name = "API TronconTypeTransport", description = "Api services troncon_type_transport")
public class TronconTypeTransportController {
    
    @Autowired
    private TronconTypeTransportService service;

    @GetMapping("/TronconTypeTransport")
    public ResponseEntity<Object> Liste() {
        try {

            List<TronconTypeTransport> result = service.Liste();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/TronconTypeTransportByIdTroncon")
    public ResponseEntity<Object> Getter(Integer idtroncon) {
        try {

            List<TronconTypeTransport> result = service.List(idtroncon);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    
    @PutMapping("/updateTronconTypeTransport/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestBody TronconTypeTransport one){
        try{
            TronconTypeTransport resultat= service.updateTronconTypeTransport(id,one);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, resultat);
        }
        catch (Exception e) {
            
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }
    }

    
    @DeleteMapping("/deleteTronconTypeTransport/{id}")
    public ResponseEntity<Object> Delete( @Validated @PathVariable Integer id){
        try {
            TronconTypeTransport resultat = service.delete(id);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, resultat);
        } 
        catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
              
    }

    // @PostMapping(value = "/addTronconTypeTransport")
    // public ResponseEntity<Object> Post(@RequestBody TronconTypeTransport troncon_typetransport) {
    //     try {
    //         TronconTypeTransport result = service.add(troncon_typetransport);
    //         return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
    //     } catch (Exception e) {
    //         return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
    //     }
    // }

}
