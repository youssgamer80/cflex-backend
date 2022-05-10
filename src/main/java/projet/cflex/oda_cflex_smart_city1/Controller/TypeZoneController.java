package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.List;
 import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projet.cflex.oda_cflex_smart_city1.Model.TypeZone;
import projet.cflex.oda_cflex_smart_city1.Repository.TypeZoneRepository;
import projet.cflex.oda_cflex_smart_city1.Service.TypeZoneService;

@RestController
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

