package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import projet.cflex.oda_cflex_smart_city1.Model.PointArret;
import projet.cflex.oda_cflex_smart_city1.Repository.PointArretRepository;
import projet.cflex.oda_cflex_smart_city1.Service.PointArretService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController // This means that this class is a Controller
@RequestMapping("/api/pointarrets")

@Tag(name = "API Point Arret", description = "Api des services des point arrets")
public class PointArretController {

    @Autowired
    private PointArretService pointArretService;
    @Autowired
    public static PointArretRepository pointarretRepository;

    @GetMapping
    public ResponseEntity<Object> Get() {
        try {
            List<PointArret> result = pointArretService.getAllPointArret();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> Get(@PathVariable int id) {
        try {
            PointArret result = pointArretService.getPointArret(id);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping(value = "/addPointArret")
    public ResponseEntity<Object> Post(@RequestBody PointArret pointarret) {
        try {
            PointArret result = pointArretService.addPointArret(pointarret);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping(value = "/updatePointArret/{id}")
    public ResponseEntity<Object> Put(@RequestBody PointArret pointarret, @PathVariable Integer id) {

        try {
            PointArret result = pointArretService.updatePointArret(id, pointarret);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }

    }

    @DeleteMapping("/deletePointArret/{id}")
    public ResponseEntity<Object> Put(@PathVariable Integer id, @RequestBody PointArret pointarret) {

        try {
            PointArret result = pointArretService.deletePointArret(id, pointarret);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }


    @GetMapping("/pointArretByCordonnees")
    public ResponseEntity<Object> GetpointArretByCord(@RequestParam Map<String, String> requestParams) {
        String lonString = requestParams.get("lon");
        String latString = requestParams.get("lat");
        String zone = requestParams.get("zone");
        double lat = Double.parseDouble(latString);
        double lon = Double.parseDouble(lonString);

        double el1 = 0;
        double el2 = 0;
        
        List<PointArret> pointarretsrResultats = new ArrayList<>();

        try {
            List<PointArret> pointArrets = (List<PointArret>) pointArretService.getPointArretByLibelle(zone);
            
            pointArrets.forEach(
                    pointArret -> {
                        System.out.println(pointArret.getNom());
                        if (distance(lat, pointArret.getLatitude(), lon, pointArret.getLongitude(), el1, el2) <= 1000) {
                           // System.out.println(distance(lat, pointArret.getLatitude(), lon, pointArret.getLongitude(), el1, el2));
                            
                            pointarretsrResultats.add(pointArret);

                        }
                    });
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK,
                    pointarretsrResultats);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }



    /*
     * @GetMapping("/getNombreDePersonnes/{id}")
     * public ResponseEntity<Object> Get( @PathVariable Integer id){
     * try{
     * PointArret result = pointArretService.NbPersonnes(id);
     * return ResponseHandler.generateResponse("Successfully deleted data!",
     * HttpStatus.OK, result);
     * } catch(Exception e){
     * return ResponseHandler.generateResponse(e.getMessage(),
     * HttpStatus.MULTI_STATUS);
     * }
     * 
     * }
     */


}