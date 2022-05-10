package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet.cflex.oda_cflex_smart_city1.Model.Zone;
import projet.cflex.oda_cflex_smart_city1.Repository.ZoneRepository;
import projet.cflex.oda_cflex_smart_city1.Service.ZoneService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/zone")
public class ZoneController {

    private ZoneService ZoneServ;
    @Autowired
    ZoneRepository zoneRepository;

    @Autowired
    public ZoneController(ZoneService ZoneServ) {
        this.ZoneServ = ZoneServ;
    }

    @GetMapping("/all")

        public ResponseEntity<List<Zone>> ListeZone(){
        List<Zone> zones = ZoneServ.listeZone();
        return new ResponseEntity<>(zones, HttpStatus.OK);       
    }

    

    @GetMapping("/{id}")
    public ResponseEntity<Zone> getZone(@PathVariable("id") Integer id){
        Zone zones = ZoneServ.ZoneById(id);
        return new ResponseEntity<>(zones, HttpStatus.OK);
    }

    @PostMapping("/add")
    public String addZone(@ModelAttribute("zone")@Validated Zone zone, BindingResult bindingResult){
        ZoneServ.save(zone);
        return ("La zone a été ajouté avec succès");
    }


    @PostMapping("/modifzone/{id}")
    public String updateZone(@PathVariable("id") Integer id, @Validated Zone zone) {
        try{
            zoneRepository.save(zone);
            return ("test");}
        catch (Exception e) {
            
            return ("id nexiste pas");
        }
    }



    @DeleteMapping("/delete/{id}")

    public ResponseEntity<Object> Put( @PathVariable Integer id, @RequestBody Zone zone) {
       
        try{
            Zone result = ZoneServ.DeleteZone(id,zone);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, result);
        } catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }


	 
}

