package projet.cflex.oda_cflex_smart_city1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projet.cflex.oda_cflex_smart_city1.Model.TypeZone;
import projet.cflex.oda_cflex_smart_city1.Repository.TypeZoneRepository;
import projet.cflex.oda_cflex_smart_city1.Service.TypeZoneService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 360000)
@RequestMapping ("/")
public class TypeZoneController{
@Autowired
    TypeZoneRepository typeZoneRepository;
    @Autowired
     private TypeZoneService typeZoneService;

    public TypeZoneController(TypeZoneService typeZoneService) {
        this.typeZoneService = typeZoneService;
    }
    // ajouter un type de zone
    @PostMapping("/add")
    public String add ( TypeZone typeZone){
        typeZoneRepository.save(typeZone);
        return " Une nouvelle zone vient d'etre ajouter";
    }
    //  lister les types de zones
    @GetMapping ("/list")
    public List<TypeZone> list(){
        return typeZoneService.listAllTypeZone();
    }

   // supprimer type zone
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        typeZoneRepository.deleteById(id);
        return "Suppression effectuées";
    }
    // informations sur un type de zone par son id
    @GetMapping("/get/{id}")
    public ResponseEntity<TypeZone> findTypeZonById(@PathVariable (value = "id") Integer id){
        Optional <TypeZone> typeZone = typeZoneRepository.findById(id);
        if (typeZone.isPresent()){
            return ResponseEntity.ok().body(typeZone.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    //  mettre à jour les  informations sur un type de zone
    @PutMapping("/update/{id}")
    TypeZone remplaceTypeZone(TypeZone newTypeZone , @PathVariable Integer id){
        return typeZoneRepository.findById(id).map(typeZone -> {typeZone.setLibelle(newTypeZone.getLibelle());
        return typeZoneRepository.save(typeZone);})
                .orElseGet(
                        ()->{
                            newTypeZone.setId(id);
                            return typeZoneRepository.save(newTypeZone);
                        }
                );
    }
}

