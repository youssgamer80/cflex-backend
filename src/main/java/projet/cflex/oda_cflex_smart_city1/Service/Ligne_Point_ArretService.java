package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.cflex.oda_cflex_smart_city1.Model.Ligne_Point_Arret;
import projet.cflex.oda_cflex_smart_city1.Repository.Ligne_Point_ArretRepository;

@Service
public class Ligne_Point_ArretService {
    @Autowired
    private final Ligne_Point_ArretRepository repository;

    public Ligne_Point_ArretService(Ligne_Point_ArretRepository repository) {
        this.repository = repository;
    }


    public List<Ligne_Point_Arret> Liste(Integer idligne){

        List<Ligne_Point_Arret> result = new ArrayList<>();
        repository.findByIdLigneFkNative(idligne).forEach(result::add);
        
        return result;


    }
 
    


    
}
