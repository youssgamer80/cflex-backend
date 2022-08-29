package projet.cflex.oda_cflex_smart_city1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import projet.cflex.oda_cflex_smart_city1.Model.TypeZone;
import projet.cflex.oda_cflex_smart_city1.Model.Zone;
import projet.cflex.oda_cflex_smart_city1.Repository.ZoneRepository;
import projet.cflex.oda_cflex_smart_city1.Service.TypeZoneService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/typezone")
public class TypeZoneController {

    @Autowired
    private TypeZoneService typeZoneService;
    @Autowired
    private ZoneRepository zoneRepository;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Get() {
        try {
            List<TypeZone> result = typeZoneService.getAllTypeZones();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // @GetMapping(value="/{id}")
    // public ResponseEntity<Object> Get(@PathVariable int id) {
    // try {
    // TypeZone result = TypeZoneService.getTypeZone(id);
    // return ResponseHandler.generateResponse("Successfully retrieved data!",
    // HttpStatus.OK, result);
    // } catch (Exception e) {
    // return ResponseHandler.generateResponse(e.getMessage(),
    // HttpStatus.MULTI_STATUS, null);
    // }
    // }

    // @GetMapping(value = "/{libelleTypeZone}")
    // public ResponseEntity<Object> Get(@PathVariable String libelleTypeZone) {
    // try {
    // TypeZone result = typeZoneService.getlibelleTypeZone(libelleTypeZone);
    // return ResponseHandler.generateResponse("Successfully retrieved data!",
    // HttpStatus.OK, result);
    // } catch (Exception e) {
    // return ResponseHandler.generateResponse(e.getMessage(),
    // HttpStatus.MULTI_STATUS, null);
    // }
    // }

    @PostMapping(value = "/addTypeZone")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Post(@RequestBody TypeZone TypeZone) {
        try {
            TypeZone result = typeZoneService.addTypeZone(TypeZone);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PutMapping(value = "/updateTypeZone/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Put(@RequestBody TypeZone TypeZone, @PathVariable Integer id) {

        try {

            TypeZone result = typeZoneService.updateTypeZone(id, TypeZone);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }

    }

    @DeleteMapping(value = "/deleteTypeZone/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Object> Put(@PathVariable Integer id){
        try {
            TypeZone result = typeZoneService.deleteTypeZone(id);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }
}
