package projet.cflex.oda_cflex_smart_city1.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import projet.cflex.oda_cflex_smart_city1.Implementation.ProprietaireServiceImpl;
import projet.cflex.oda_cflex_smart_city1.Model.Proprietaire;
import projet.cflex.oda_cflex_smart_city1.Model.Usager;
import projet.cflex.oda_cflex_smart_city1.Repository.ProprietaireRepository;
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
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("proprietaire")
@RequiredArgsConstructor
public class ProprietaireController {
    @Autowired
    private final ProprietaireServiceImpl proprietaireService;
    @Autowired
    ProprietaireRepository proprietaireRepository;

    @GetMapping("/list")
    public ResponseEntity<Response> getProprietaire(){
        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("proprietaire", proprietaireService.list(true)))
                .message("Proprietaire recupéré")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveProprietaire(@RequestBody @Validated Proprietaire proprietaire){
        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("proprietaire", proprietaireService.create(proprietaire)))
                .message("Proprietaire enregistré avec succès")
                .status(CREATED)
                .statusCode(CREATED.value())
                .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getProprietaire(@PathVariable("id") Integer id){
        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("proprietaire", proprietaireService.get(id)))
                .message("Proprietaire retrouvé")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteProprietaire(@PathVariable("id") Integer id){
        boolean exists = proprietaireRepository.existsById(id);
        if(!exists){throw new IllegalStateException("Le proprietaire avec le numero "+id+" n'existe pas");}
        else {
            return ResponseEntity.ok(Response.builder().timeStamp(now()).
                    data(Map.of("delete", proprietaireService.delete(id)))
                    .message("Le propriétaire avec le numero "+id+" a été supprimé avec succès")
                    .status(OK)
                    .statusCode(OK.value())
                    .build()
            );}
    }



    @GetMapping(path = "/image/{permis}", produces = IMAGE_PNG_VALUE)
    public byte[] getProprietairePermis(@PathVariable("permis") String permis) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Downloads/images"+permis));
    }

    @GetMapping(path = "/image/{pieceidentite}", produces = IMAGE_PNG_VALUE)
    public byte[] getProprietairePieceIdentite(@PathVariable("pieceidentite") String pieceidentite) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Downloads/images"+pieceidentite));
    }

    @PutMapping(value = "/updateProprio/{id}")
    public ResponseEntity<Object> Put(@RequestBody Proprietaire proprietaire, @PathVariable Integer id) {

        try{
            Proprietaire result = proprietaireService.majProprietaire(id, proprietaire);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }

    }

}
