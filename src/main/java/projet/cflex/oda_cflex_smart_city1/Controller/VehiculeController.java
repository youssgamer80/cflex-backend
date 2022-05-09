package projet.cflex.oda_cflex_smart_city1.Controller;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import projet.cflex.oda_cflex_smart_city1.Service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehiculeController {
    @Autowired
    VehiculeService vehiculeService;

    @GetMapping("/listevehicule")
    @ResponseBody
    public List<Vehicule> ListeVehicule(ModelMap modelMap){
        List <Vehicule> listevehicule = vehiculeService.findAll();
        return listevehicule;
    }

    //Endpoint retournant la liste des infos pour un véhicule donné
    @GetMapping("/listeinfovehicule/{id}")
    @ResponseBody
    public Object listinfoproprio(@Validated @PathVariable("id") Integer id) {
        try {
            Vehicule infovehicule = vehiculeService.findOne(id)
                    .orElseThrow(() -> new IllegalArgumentException("Id invalide" + id));

            return (infovehicule);
        }
        catch (Exception e){
            return ("Le véhicule avec l'Id:"+id+" n'existe pas");
        }
    }

    @PostMapping(value = "/addvehicule")
    public String addVehicule(@ModelAttribute("vehicule")@Validated Vehicule vehicule, BindingResult bindingResult){
        vehiculeService.save(vehicule);
        return ("Le vehicule a été ajouté avec succès");
    }


    @DeleteMapping("/suppvehicule/{id}")
    public String suppvehicule( @PathVariable Integer id){
        vehiculeService.delete(id);
        return ("Le véhicule  "+id+" a été supprimé avec succès");
    }

    @PutMapping("/modifvehicule/{id}")
    @ResponseBody
    public String modifvehicule(@PathVariable("id") Integer id) {
        try{
            vehiculeService.findOne(id)
                    .orElseThrow(() -> new IllegalArgumentException("Id invalide:" + id));

            return("La modification des informations du vehicule "+id+"a été effectuée");
        }
        catch (Exception e){
            return ("L'id n'existe pas");
        }

    }
}
