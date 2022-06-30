package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import projet.cflex.oda_cflex_smart_city1.Model.TronconTypeTransport;
import projet.cflex.oda_cflex_smart_city1.Service.TronconTypeTransportService;

@RestController // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/api/troncontypetransport")
@Tag(name = "API TronconTypeTransport", description = "Api des services des troncon_type_transport")
public class TronconTypeTransportController {

    @Autowired
    private TronconTypeTransportService troncontypetransportservie;

    @GetMapping
    public ResponseEntity<Object> Get() {
        try {
            List<TronconTypeTransport> result = troncontypetransportservie.Liste();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/TronconTypeTransportByIdTroncon")
    public ResponseEntity<Object> Getter(Integer idtroncon) {
        try {

            List<TronconTypeTransport> result = troncontypetransportservie.ListByTroncon(idtroncon);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @PostMapping(value = "/addTronconTypeTransport")
    public ResponseEntity<Object> Post(@RequestBody TronconTypeTransportObjet tronconTypeTransportObjet) {
        try {
            TronconTypeTransport result = troncontypetransportservie.add(tronconTypeTransportObjet);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    
}
