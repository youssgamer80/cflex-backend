package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping(value="/{id}")
        public ResponseEntity<Object> Get(@PathVariable int id) {
            try {
                Borne result = borneService.getBorne(id);
                return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
            } catch (Exception e) {
                return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
            }
        }
}
