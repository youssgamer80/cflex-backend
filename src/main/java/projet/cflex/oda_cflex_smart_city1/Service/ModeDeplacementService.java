package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.ModeDeplacement;
import projet.cflex.oda_cflex_smart_city1.Repository.ModeDeplacementRepository;
@Service
public class ModeDeplacementService {

    @Autowired
    private final ModeDeplacementRepository repo;

    @Autowired
    public ModeDeplacementService(ModeDeplacementRepository repo) {
        this.repo = repo;
    }


    public List<ModeDeplacement> Listemodes(){
        return repo.findAll();
    }

    public Optional<ModeDeplacement> ModeById(Integer id){
        return repo.findById(id);
    }

    public ModeDeplacement AddMode( ModeDeplacement newmode){
        return repo.save(newmode);
    }

    public ModeDeplacement UpdateMode(Integer id ,ModeDeplacement unmode){

        ModeDeplacement existingMode = this.repo.findById(id).orElseThrow(() -> new RuntimeException("Mode de déplacementt" + id + "nexiste pas"));

        if(unmode.getModeDeplacement()== null){
            unmode.setModeDeplacement(existingMode.getModeDeplacement());

        }
        return repo.save(unmode);
    }

    
    public ModeDeplacement DeleteMode(Integer id, ModeDeplacement modedeplacement){
        ModeDeplacement realMode = this.repo.findById(id).orElseThrow(() -> new RuntimeException("Mode de déplacement" + id + "nexiste pas"));
        realMode.setStatut(modedeplacement.getStatut());
        return repo.save(realMode);
    }


    
}

