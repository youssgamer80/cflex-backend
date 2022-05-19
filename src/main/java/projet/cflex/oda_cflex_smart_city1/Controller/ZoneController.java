package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import projet.cflex.oda_cflex_smart_city1.Model.Zone;
import projet.cflex.oda_cflex_smart_city1.Repository.ZoneRepository;
import projet.cflex.oda_cflex_smart_city1.Service.ZoneService;
import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;

@RestController
@RequestMapping("/api/v1/Zone")

@Tag(name = "L'API de Zone", description = "L'Api de la gestion des zones")
public class ZoneController {

    private final ZoneService ZoneServ;
    @Autowired
    ZoneRepository zoneRepository;

    @Autowired
    public ZoneController(ZoneService ZoneServ) {
        this.ZoneServ = ZoneServ;
    }

    @GetMapping("/getZones")
        public ResponseEntity<List<Zone>> ListeZone(){
        List<Zone> zones = ZoneServ.listeZone();
        return new ResponseEntity<>(zones, HttpStatus.OK);       
    }

    

    @GetMapping("/getZoneById/{id}")
    public Object UneZone(@Validated @PathVariable("id") Integer id){

            Zone zone = ZoneServ.ZoneById(id).orElseThrow(() -> new IllegalArgumentException("Id invalide" + id));
            return zone;

    }


    @PostMapping("/addZone")
    public String createZone(@Valid @RequestBody @NotNull ZoneObjet input) {
        Zone zone = new Zone();
        saveZone(input, zone);
        return "Demande créée avec succes";
    }

    /**
     * Procedure pour gerer l'enregistrement d'une zone
     * @param input
     * @param zone
     */

    private void saveZone(@RequestBody @Valid @NotNull ZoneObjet input, Zone zone){

        zone.setLibelle(input.getLibelle());
        zone.setIdTypeZoneFk(input.getIdTypeZoneFk());
        zone.setId_zoneparent(input.getId_zoneparent());
        ZoneServ.Addzone(zone);

    }

    @PutMapping("/updateZone/{id}")
    public ResponseEntity<Object> updateZone(@PathVariable("id") Integer id, @Validated @RequestBody Zone zone) {
        try{
            Zone resultat= ZoneServ.updateZone(id, zone);
            return ResponseHandler.generateResponse("Successfully updated data!", HttpStatus.OK, resultat);
        }
        catch (Exception e) {
            
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, e);
        }
    }


    @DeleteMapping("/deleteZone/{id}")
    public ResponseEntity<Object> Put( @PathVariable Integer id) {
       
        try{
            Zone result = ZoneServ.deleteZone(id);
            return ResponseHandler.generateResponse("Successfully deleted data!", HttpStatus.OK, result);
        } catch(Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }

}

