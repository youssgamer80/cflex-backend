package projet.cflex.oda_cflex_smart_city1.Controller;

import projet.cflex.oda_cflex_smart_city1.Model.Proprietaire;
import projet.cflex.oda_cflex_smart_city1.Repository.ProprietaireRepository;
import projet.cflex.oda_cflex_smart_city1.Service.ProprietaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProprietaireController {
    @Autowired
    ProprietaireService suppproprietaireService;
    @Autowired
    ProprietaireService majproprietaireService;
    @Autowired
    ProprietaireService editproprietaire;
    @Autowired
    ProprietaireService infoproprio;
    @Autowired
    private ProprietaireRepository proprietaireRepository;

    @GetMapping("/listeproprietaire")
    @ResponseBody
    public List<Proprietaire> ListeProprio(ModelMap modelMap){
        List <Proprietaire> listeproprio = proprietaireRepository.findAll();
        return listeproprio;
    }

    //Endpoint retournant la liste des infos pour un propriétaire donné
   @GetMapping("/listeinfoproprietaire/{id}")
    @ResponseBody
    public Object listinfoproprio(@Validated @PathVariable("id") Integer id) {
        try {
            Proprietaire infoproprietaire = infoproprio.findOne(id)
                    .orElseThrow(() -> new IllegalArgumentException("Id invalide" + id));

            return (infoproprietaire);
        }
        catch (Exception e){
          return ("Le propriétaire aved l'Id:"+id+" n'existe pas");
        }
   }

    @PostMapping(value = "/addproprio")
    public String addProprio(@ModelAttribute("proprio")@Validated Proprietaire proprietaire, BindingResult bindingResult){
        proprietaireRepository.save(proprietaire);
        return ("Le proprietaire a été ajouté avec succès");
    }


    @DeleteMapping("/suppproprietaire/{id}")
    public String suppproprietaire( @PathVariable Integer id){
        suppproprietaireService.delete(id);
        return ("Le propriétaire  "+id+" a été supprimé avec succès");
    }



    @GetMapping("/modifproprio/{id}")
    @ResponseBody
    public String modifproprietaire(@PathVariable("id") Integer id) {
        try{
            Proprietaire proprietaire = editproprietaire.findOne(id)
                    .orElseThrow(() -> new IllegalArgumentException("Id invalide:" + id));

            return("La modification des informations du proprietaire "+id+"a été effectuée");
        }
        catch (Exception e){
            return ("L'id n'existe pas");
        }

    }
}
