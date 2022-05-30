package projet.cflex.oda_cflex_smart_city1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projet.cflex.oda_cflex_smart_city1.Model.PositionVehicule;
import projet.cflex.oda_cflex_smart_city1.Implementation.PositionVehiculeServiceImpl;

import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import projet.cflex.oda_cflex_smart_city1.Repository.PositionVehiculeRepository;
import projet.cflex.oda_cflex_smart_city1.Response.Response;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("tracker")
public class PositionVehiculeController {
    @Autowired
    PositionVehiculeServiceImpl positionVehiculeImpl;
    @Autowired
    PositionVehiculeRepository positionVehiculeRepository;

    @PostMapping("/setposition")
    public ResponseEntity<Response> setPositiontracker( @RequestBody @Validated PositionVehicule positionVehicule){
        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("vehicule", positionVehiculeImpl.create(positionVehicule)))
                .message("La position du véhicule a été enregistrée avec succès")
                .status(CREATED)
                .statusCode(CREATED.value())
                .build()
        );
    }

/*    @GetMapping("/getpositions")
    public ResponseEntity<?> getallpositions(){
        List positionVehiculeList = positionVehiculeRepository.findAll();
        if (positionVehiculeList.size()>0) {
            return new ResponseEntity<List<PositionVehicule>>(positionVehiculeList, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Aucune position valable", HttpStatus.NOT_FOUND);
        }

    }*/


    @GetMapping("/getposition/{id}")
    public ResponseEntity<?> getSinglePosition(@PathVariable ("id")Long id){
        Optional<PositionVehicule> positionVehiculeOpt = positionVehiculeRepository.findById(id);
        if(positionVehiculeOpt.isPresent()){
            return new ResponseEntity<>(positionVehiculeOpt.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Le tracker avec cet id n'existe pas"+id,HttpStatus.NOT_FOUND);
        }
    }
}
