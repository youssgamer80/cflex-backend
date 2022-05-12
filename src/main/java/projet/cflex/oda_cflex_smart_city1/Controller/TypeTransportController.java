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

import projet.cflex.oda_cflex_smart_city1.Model.TypeTransport;
import projet.cflex.oda_cflex_smart_city1.Service.TypeTransportService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;


@RestController   
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600) 
@RequestMapping("/api/typetransport")
public class TypeTransportController {

    @Autowired
    private TypeTransportService typeTransportService;
    @GetMapping
        public ResponseEntity<Object> Get() {
            try {
                List<TypeTransport> result = typeTransportService.getAllTypeTransports();
                return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

        @GetMapping(value="/{id}")
        public ResponseEntity<Object> Get(@PathVariable int id) {
            try {
                TypeTransport result = typeTransportService.getTypeTransport(id);
                return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }

    @PostMapping(value = "/addtypetransport")
    public ResponseEntity<Object> Post(@RequestBody TypeTransport typeTransport) {
        try {
            TypeTransport result = typeTransportService.addTypeTransport(typeTransport);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping(value = "/updatetypetransport/{id}")
    public ResponseEntity<Object> Put(@RequestBody TypeTransport typeTransport, @PathVariable Integer id) {
        
        try{
            TypeTransport result = typeTransportService.updateTypeTransport(id, typeTransport);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }
    
    }

    @DeleteMapping(value = "/deletetypetransport/{id}")
    public ResponseEntity<Object> Put( @PathVariable Integer id, @RequestBody TypeTransport typeTransport) {
       
        try{
            TypeTransport result = typeTransportService.deleteTypeTransport(id,typeTransport);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, result);
        } catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }


}
