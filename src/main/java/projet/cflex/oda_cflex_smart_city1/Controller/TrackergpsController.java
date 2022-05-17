package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import projet.cflex.oda_cflex_smart_city1.Model.Trackergps;
import projet.cflex.oda_cflex_smart_city1.Service.TrackergpsService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;


@RestController
@Controller
@RequestMapping("/api/v1/trackergps")
public class TrackergpsController {
    
    @Autowired
    private TrackergpsService trackergpsService;

    @GetMapping
    public ResponseEntity<Object> Get(){

        try {
            List<Trackergps> result = trackergpsService.getAllTrackergps();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> Get(@PathVariable int id) {
        try {
            Trackergps result = trackergpsService.getTrackergps(id);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @PostMapping(value = "/addtrackergps")
    public ResponseEntity<Object> Post(@RequestBody Trackergps trackergps) {
        try {
            Trackergps result = trackergpsService.addTrackergps(trackergps);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    
    @DeleteMapping(value = "/deletetrackergps/{id}")
    public ResponseEntity<Object> Put(@PathVariable Integer id, @RequestBody Trackergps trackergps) {

        try {
            Trackergps result = trackergpsService.deleteTrackergps(id, trackergps);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }
    

    @PutMapping(value = "/updatetrackergps/{id}")
    public ResponseEntity<Object> Put(@RequestBody Trackergps trackergps, @PathVariable Integer id) {
        
        try{
            Trackergps result = trackergpsService.updateTrackergps(trackergps, id);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
        }catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }
    
    }

}
