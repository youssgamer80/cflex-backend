package projet.cflex.oda_cflex_smart_city1.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import projet.cflex.oda_cflex_smart_city1.Implementation.TrackergpsServiceImpl;
import projet.cflex.oda_cflex_smart_city1.Model.Trackergps;
import projet.cflex.oda_cflex_smart_city1.Repository.TrackergpsRepository;
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
@RequestMapping("api/v1/trackergps")
public class TrackergpsController {

    @Autowired
    private final TrackergpsServiceImpl trackergpsServiceImpl;

    @Autowired
    TrackergpsRepository trackergpsRepository;

    @GetMapping("/list")
    public ResponseEntity<Response> getTrackergps() {
        return ResponseEntity
                .ok(Response.builder().timeStamp(now()).data(Map.of("borne", trackergpsServiceImpl.list(true)))
                        .message("trackergps recupéré")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    @PostMapping("/addTrackergps")
    public ResponseEntity<Response> saveTrackergps(@RequestBody @Validated Trackergps trackergps) {
        // System.out.print(trackergps.getLibelle());
        return ResponseEntity.ok(
                Response.builder().timeStamp(now()).data(Map.of("trackergps", trackergpsServiceImpl.create(trackergps)))
                        .message("Trackergps enregistré avec succès")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build());
    }

    @GetMapping("{id}")
    public ResponseEntity<Response> getTrackergps(@PathVariable("id") Integer id) {
        return ResponseEntity
                .ok(Response.builder().timeStamp(now()).data(Map.of("borne", trackergpsServiceImpl.get(id)))
                        .message("trackergps retrouvé")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteTrackergps(@PathVariable("id") Integer id) {
        boolean exists = trackergpsRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Le trackergps avec le numero " + id + " n'existe pas");
        } else {
            return ResponseEntity
                    .ok(Response.builder().timeStamp(now()).data(Map.of("delete", trackergpsServiceImpl.delete(id)))
                            .message("Le trackergps avec le numero " + id + " a été supprimé avec succès")
                            .status(OK)
                            .statusCode(OK.value())
                            .build());
        }
    }


    @PutMapping(value = "/updateProprio/{id}")
    public ResponseEntity<Object> Put(@RequestBody Trackergps trackergps, @PathVariable Integer id) {

        try{
            Trackergps result = trackergpsServiceImpl.majTrackergps(id, trackergps);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }

    }

}
