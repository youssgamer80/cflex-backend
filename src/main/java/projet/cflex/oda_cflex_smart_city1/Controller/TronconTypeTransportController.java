package projet.cflex.oda_cflex_smart_city1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import projet.cflex.oda_cflex_smart_city1.Service.TronconTypeTransportService;

@RestController // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/api/troncon_typetransport")
@Tag(name = "API TronconTypeTransport", description = "Api services troncon_type_transport")
public class TronconTypeTransportController {
    
    @Autowired
    private TronconTypeTransportService service;
}
