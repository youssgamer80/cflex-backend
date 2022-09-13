package projet.cflex.oda_cflex_smart_city1.Controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import projet.cflex.oda_cflex_smart_city1.Implementation.StationnerServiceImpl;
import projet.cflex.oda_cflex_smart_city1.Model.Stationner;
import projet.cflex.oda_cflex_smart_city1.Repository.StationnerRepository;
import projet.cflex.oda_cflex_smart_city1.Response.Response;

import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@Data
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/stationnement")
@RequiredArgsConstructor
public class StationnerController {
    StationnerServiceImpl stationnerService;
    @Autowired
    StationnerRepository stationnerRepository;
    @GetMapping("/liststationnement/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Response> getStatVehicule(@PathVariable("id") Integer id){
        List<Stationner> listeStationnement= stationnerRepository.findAll();
        List<Stationner> filteredListStationnement = listeStationnement.stream()
                .filter(s -> s.getVehicule().getId() == id).toList();
        /*List < PointArret> filterListPointArret = new ArrayList<>();
        filteredListStationnement.forEach(stationner ->filterListPointArret
                .add(stationner.getIdPointArretFk()) );*/
        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("Stationnement",filteredListStationnement))
                .message("Liste des stationnements d'un véhicule")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

}