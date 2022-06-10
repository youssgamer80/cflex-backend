package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import projet.cflex.oda_cflex_smart_city1.Model.Ligne;
import projet.cflex.oda_cflex_smart_city1.Model.Ligne_Point_Arret;
import projet.cflex.oda_cflex_smart_city1.Repository.Ligne_Point_ArretRepository;
import projet.cflex.oda_cflex_smart_city1.Service.LigneService;
import projet.cflex.oda_cflex_smart_city1.Service.Ligne_Point_ArretService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController
@RequestMapping("/api/v1/Ligne_Point_Arret")
public class Ligne_Point_ArretController {
    @Autowired
    private final Ligne_Point_ArretRepository repo;

    public Ligne_Point_ArretController(Ligne_Point_ArretRepository repo) {
        this.repo = repo;
    }

    @Autowired
    private Ligne_Point_ArretService service;


    @GetMapping("/Ligne_Point_Arret")
    public ResponseEntity<Object> Getter(Integer idligne) {
        try {

            List<Ligne_Point_Arret> result = service.Liste(idligne);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


}
