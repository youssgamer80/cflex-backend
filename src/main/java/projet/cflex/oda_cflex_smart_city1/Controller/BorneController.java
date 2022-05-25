package projet.cflex.oda_cflex_smart_city1.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import projet.cflex.oda_cflex_smart_city1.Implementation.BorneServiceImpl;
import projet.cflex.oda_cflex_smart_city1.Model.Borne;
import projet.cflex.oda_cflex_smart_city1.Repository.BorneRepository;
import projet.cflex.oda_cflex_smart_city1.Response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;


@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("api/v2/bornes")
public class BorneController {

    @Autowired
    private final BorneServiceImpl borneServiceImpl;

    @Autowired
    BorneRepository borneRepository;

    @GetMapping("/list")
    public ResponseEntity<Response> getBorne(){
        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("borne", borneServiceImpl.list(true)))
                .message("borne recupéré")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @PostMapping("/addBorne")
    public ResponseEntity<Response> saveBorne(@RequestBody @Validated Borne borne){
        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("borne", borneServiceImpl.create(borne)))
                .message("borne enregistré avec succès")
                .status(CREATED)
                .statusCode(CREATED.value())
                .build()
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<Response> getBorne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("borne", borneServiceImpl.get(id)))
                .message("borne retrouvé")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteBorne(@PathVariable("id") Integer id){
        boolean exists = borneRepository.existsById(id);
        if(!exists){throw new IllegalStateException("La borne avec le numero "+id+" n'existe pas");}
        else {
            return ResponseEntity.ok(Response.builder().timeStamp(now()).
                    data(Map.of("delete", borneServiceImpl.delete(id)))
                    .message("La borne avec le numero "+id+" a été supprimé avec succès")
                    .status(OK)
                    .statusCode(OK.value())
                    .build()
            );}
    }

}
