package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

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

import projet.cflex.oda_cflex_smart_city1.Model.TypeTransport;
import projet.cflex.oda_cflex_smart_city1.Service.TypeTransportService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;


@RestController   
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/typetransport")
public class TypeTransportController {

    @Autowired
    private TypeTransportService typeTransportService;
    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
        public ResponseEntity<Object> Get() {
            try {
                List<TypeTransport> result = typeTransportService.getAllTypeTransports();
                return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

        // @GetMapping(value="/{id}")
        // public ResponseEntity<Object> Get(@PathVariable int id) {
        //     try {
        //         TypeTransport result = typeTransportService.getTypeTransport(id);
        //         return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        //     } catch (Exception e) {
        //         return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        //     }
        // }

        @GetMapping(value="/{libelleTypeTransport}")
        @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
        public ResponseEntity<Object> Get(@PathVariable String libelleTypeTransport) {
            try {
                TypeTransport result = typeTransportService.getlibelleTypeTransport(libelleTypeTransport);
                return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

    @PostMapping(value = "/addtypetransport")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Post(@RequestBody TypeTransport typeTransport) {
        try {
            TypeTransport result = typeTransportService.addTypeTransport(typeTransport);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping(value = "/updatetypetransport/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Put(@RequestBody TypeTransport typeTransport, @PathVariable Integer id) {
        
        try{
            TypeTransport result = typeTransportService.updateTypeTransport(id, typeTransport);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }
    
    }

    @DeleteMapping(value = "/deletetypetransport/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Put( @PathVariable Integer id, @RequestBody TypeTransport typeTransport) {
       
        try{
            TypeTransport result = typeTransportService.deleteTypeTransport(id,typeTransport);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, result);
        } catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }


}
