package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.cflex.oda_cflex_smart_city1.Model.TypePointArret;
import projet.cflex.oda_cflex_smart_city1.Repository.TypePointArretRepository;

@Service
public class TypePointArretService {
    private Boolean statut=true;

    @Autowired
    private final TypePointArretRepository repository;

    @Autowired
    public TypePointArretService(TypePointArretRepository repository) {
        this.repository = repository;
    }

    public List<TypePointArret> Liste(){
        List<TypePointArret> types = new ArrayList<>();
        repository.findByStatutJPQL(statut).forEach(types::add);

        return types;
    }
    
    public Optional<TypePointArret> TypePAById(Integer id){
        return repository.findById(id);

    }

    public TypePointArret NewTypePA(TypePointArret type){
        type.setStatut(true);
        return repository.save(type);
    }

    public TypePointArret updateTypePA(Integer id, TypePointArret type){
        
        TypePointArret realType = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Type de point d'arrêt" + id + "nexiste pas"));
        if(type.getTypePointArret()!= null){
            realType.setTypePointArret(type.getTypePointArret());

        }
        if(type.getStatut()!= null){
            realType.setStatut(type.getStatut());

        } 
               
        return repository.save(realType);

    } 

    public TypePointArret deleteTypePA(Integer id){
        TypePointArret realType = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Type de point d arrêt" + id + "nexiste pas"));
        realType.setStatut(false);
        return repository.save(realType);
    }
}
