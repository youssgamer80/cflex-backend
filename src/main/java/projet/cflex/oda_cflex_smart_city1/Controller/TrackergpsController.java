package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.cflex.oda_cflex_smart_city1.Model.Trackergps;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import projet.cflex.oda_cflex_smart_city1.Service.TrackergpsService;
import projet.cflex.oda_cflex_smart_city1.Service.VehiculeService;
import projet.cflex.oda_cflex_smart_city1.Repository.TrackergpsRepository;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/Trackergpss")
public class TrackergpsController {

    @Autowired
    private TrackergpsService trackergpsService;

    @Autowired
    private TrackergpsRepository trackergpsRepository;

    @Autowired
    private VehiculeService vehiculeService;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Get() {
        try {
            List<Trackergps> result = trackergpsService.getAllTrackergps();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping(value = "byid/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Get(@PathVariable int id) {
        try {
            Trackergps result = trackergpsService.getTrackergpsBydId(id);
            return ResponseHandler.generateResponse("Successfully retrieved data!",
                    HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(),
                    HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping(value = "/{nomTrackergps}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Get(@PathVariable String nomTrackergps) {
        try {

            Trackergps result = trackergpsService.getTrackergps(nomTrackergps);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping(value = "/addTrackergps")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Post(@RequestBody TrackergpsObject trackergpsObject) {
        try {

            String message;
            Vehicule vehicule = vehiculeService.get(trackergpsObject.idVehiculeFk);
            Trackergps result;

            if (!trackergpsRepository.existsTrackergpsByIdVehiculeFk(vehicule)) {

                message = "Successfully added data!";
                result = trackergpsService.addTrackergps(trackergpsObject);

            } else {
                message = "Ce trackergps est dejà affilié à un véhicule";
                System.out.print("Vehicule existe deja");
                result = null;
            }

            // Trackergps result = null;
            return ResponseHandler.generateResponse(message, HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping(value = "/updateTrackergps/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Put(@RequestBody TrackergpsObject TrackergpsObject, @PathVariable Integer id) {

        try {
            Trackergps result = trackergpsService.updateTrackergps(id, TrackergpsObject);
            return ResponseHandler.generateResponse("Successfully updated data!",
                    HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(),
                    HttpStatus.MULTI_STATUS, e);
        }

    }

    @DeleteMapping(value = "/deleteTrackergps/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Put(@PathVariable Integer id) {

        try {
            Trackergps result = trackergpsService.deleteTrackergps(id);
            return ResponseHandler.generateResponse("Successfully deleted data!",
                    HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(),
                    HttpStatus.MULTI_STATUS);
        }
    }

}
