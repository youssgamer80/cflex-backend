package projet.cflex.oda_cflex_smart_city1.Controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import projet.cflex.oda_cflex_smart_city1.Model.Proprietaire;
import projet.cflex.oda_cflex_smart_city1.Model.Stationner;
import projet.cflex.oda_cflex_smart_city1.Repository.StationnerRepository;
import projet.cflex.oda_cflex_smart_city1.Service.StationnerService;

import java.util.List;
import java.util.Optional;

@Data
@RestController
public class StationnerController {
    StationnerService stationnerService;
    @Autowired
    StationnerRepository stationnerRepository;
    @GetMapping("test")
    public String lol(@RequestBody Stationner stationner){
        return (stationner.getIdVehiculeFk().getMarque());
    }


}