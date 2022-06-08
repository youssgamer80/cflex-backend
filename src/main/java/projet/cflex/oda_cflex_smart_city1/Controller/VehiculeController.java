package projet.cflex.oda_cflex_smart_city1.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import projet.cflex.oda_cflex_smart_city1.Implementation.VehiculeServiceImpl;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projet.cflex.oda_cflex_smart_city1.Repository.VehiculeRepository;
import projet.cflex.oda_cflex_smart_city1.Response.Response;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("vehicule")
@RequiredArgsConstructor
public class VehiculeController {
    @Autowired
    private final VehiculeServiceImpl vehiculeService;
    @Autowired
    VehiculeRepository vehiculeRepository;

    @GetMapping("/list")
    public ResponseEntity<Response> getVehicule(){
        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("vehicule", vehiculeService.list(true)))
                .message("Liste des véhicules")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @GetMapping("/listvehiculesproprio/{id}")
    public ResponseEntity<Response> getVehiculeProprio(@PathVariable("id") Integer id){
        List<Vehicule> listeVehicule= vehiculeRepository.findAll();
        List<Vehicule> filteredListVehicule = listeVehicule.stream()
                .filter(s -> s.getProprietaire().getId()==id)
                .collect(Collectors.toList());
        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("vehicule",filteredListVehicule))
                .message("Liste des véhicules d'un propriétaire")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }
/*    @PostMapping("/save")
    public ResponseEntity<Response> saveVehicule( @RequestBody @Validated Vehicule vehicule){

        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("vehicule", vehiculeService.create(vehicule)))
                .message("Véhicule enregistré avec succès")
                .status(CREATED)
                .statusCode(CREATED.value())
                .build()
        );
    }*/
    @PostMapping("/savevehicule")
    public ResponseEntity<Vehicule> createVehicule(Vehicule vehicule) {

        if(vehicule.getProprietaire().getStatut()==false) {
            return new ResponseEntity<>(null, NOT_ACCEPTABLE);
        }
        else {
            vehiculeRepository.save(vehicule);
            return (ResponseEntity<Vehicule>) ResponseEntity.ok(Response.builder().timeStamp(now()).
                    data(Map.of("vehicule", vehiculeService.create(vehicule)))
                    .message("Véhicule enregistré avec succès")
                    .status(CREATED)
                    .statusCode(CREATED.value())
                    .build()
            );
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getProprietaire(@PathVariable("id") Integer id){
        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("vehicule", vehiculeService.get(id)))
                .message("Véhicule retrouvé")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteVehicule(@PathVariable("id") Integer id){
        boolean exists = vehiculeRepository.existsById(id);
        if(!exists){throw new IllegalStateException("Le vehicule avec le numero "+id+" n'existe pas");}
        else {
            return ResponseEntity.ok(Response.builder().timeStamp(now()).
                    data(Map.of("delete", vehiculeService.delete(id)))
                    .message("Le vehicule avec le numero "+id+" a été supprimé avec succès")
                    .status(OK)
                    .statusCode(OK.value())
                    .build()
            );}
    }

    @PutMapping(value = "/updateVehicule/{id}")
    public ResponseEntity<Object> Put(@RequestBody Vehicule vehicule, @PathVariable Integer id) {

        try{
            Vehicule result = vehiculeService.majVehicule(id, vehicule);
            return ResponseHandler.generateResponse("Mise à jour effectuée avec succès!", HttpStatus.OK, result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }
    }

}
