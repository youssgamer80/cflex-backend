package projet.cflex.oda_cflex_smart_city1.Service;

import  java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.TypeZone;
import projet.cflex.oda_cflex_smart_city1.Repository.TypeZoneRepository;
@Service
public class TypeZoneService {
    @Autowired
    private TypeZoneRepository typeZoneRepository;

    public TypeZoneService (TypeZoneRepository  typeZoneRepository){
        this.typeZoneRepository = typeZoneRepository;
    }
     // Service add

    public  void saveTypeZone(TypeZone  typeZone) {
        typeZoneRepository.save(typeZone);
    }
     //  Service List
    public List<TypeZone>listAllTypeZone(){
        return typeZoneRepository.findAll();
    }
    //Service Get by id
    public TypeZone get ( Integer  id){
        return typeZoneRepository.findById(id).get();
    }
    //Service Delete
   public String delete ( Integer id){
        typeZoneRepository.deleteById(id);
        return "Supprimé avec Succès";
   }
    //Service Put


}

