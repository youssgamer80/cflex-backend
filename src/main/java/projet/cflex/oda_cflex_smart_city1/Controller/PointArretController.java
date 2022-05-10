package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.cflex.oda_cflex_smart_city1.Model.PointArret;
import projet.cflex.oda_cflex_smart_city1.Repository.PointArretRepository;
import projet.cflex.oda_cflex_smart_city1.Service.PointArretService;

@RestController
@RequestMapping("/api/PointArret")
public class PointArretController {

    private PointArretService pointarretservice;
 
    @Autowired
    PointArretRepository pointarretrepo;
    public PointArretController(PointArretService pointarretservice) {
        this.pointarretservice = pointarretservice;
    }


    @GetMapping("/Liste")
    public ResponseEntity<List<PointArret>> ListePointArret(){
        List<PointArret> pointarrets = pointarretservice.ListePointArret();
        return new ResponseEntity<>(pointarrets, HttpStatus.OK);       
    }

    @GetMapping("/{id}")
    public ResponseEntity<PointArret> getZone(@PathVariable("id") Integer id){
        PointArret pointArret = pointarretservice.PointById(id);
        return new ResponseEntity<>(pointArret, HttpStatus.OK);
    }

    @PostMapping("/add")
    public String addZone(@ModelAttribute("zone")@Validated PointArret newpointarret, BindingResult bindingResult){
        pointarretservice.save(newpointarret);
        return ("La zone a été ajouté avec succès");
    }


    
}
