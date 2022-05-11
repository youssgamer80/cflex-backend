package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Borne;
import projet.cflex.oda_cflex_smart_city1.Repository.BorneRepository;

@Service
public class BorneService {
    
    @Autowired
    public BorneRepository borneRepository;
    private Boolean statut=true;


    // list of methods 
    public List<Borne> getAllBornes() {
        
        List<Borne> bornes = new ArrayList<>();

        borneRepository.findByStatutJPQL(statut).forEach(bornes::add);

        return bornes;
    }


    public Borne addBorne(Borne borne) {

        return borneRepository.save(borne);
    }

    // public Borne getBorne(int id) {

    //     return this.borneRepository.findById(id)
    //     .orElseThrow(() -> new ResourceNotFoundException("Type Transport not found with id :" + id));
    // }
}
