package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.CrossOrigin;

import projet.cflex.oda_cflex_smart_city1.Implementation.BorneServiceImpl;
import projet.cflex.oda_cflex_smart_city1.Model.Proprietaire;
import projet.cflex.oda_cflex_smart_city1.Repository.BorneRepository;
import projet.cflex.oda_cflex_smart_city1.Response.Response;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;
import projet.cflex.oda_cflex_smart_city1.Model.Borne;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("borne")
@RequiredArgsConstructor
public class BorneController {

    @Autowired
    private BorneServiceImpl borneService;
    @Autowired
    BorneRepository borneRepository;

    @PostMapping("/save")
    public ResponseEntity<Response> saveBorne(@RequestBody @Validated Borne borne){
        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("borne", borneService.create(borne)))
                .message("Borne enregistrée avec succès")
                .status(CREATED)
                .statusCode(CREATED.value())
                .build()
        );
    }
}
