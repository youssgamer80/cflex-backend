package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.ModeDeplacement;
import projet.cflex.oda_cflex_smart_city1.Repository.ModeDeplacementRepository;

@Service
public class ModeDeplacementService {
    private Boolean statut=true;

    @Autowired
    private final ModeDeplacementRepository repository;

    @Autowired
    public ModeDeplacementService(ModeDeplacementRepository repository) {
        this.repository = repository;
    }

    public List<ModeDeplacement> Liste(){

        List<ModeDeplacement> modes = new ArrayList<>();
        repository.findByStatutJPQL(statut).forEach(modes::add);

        return modes;
    }
    
    public Optional<ModeDeplacement> ModeById(Integer id){
        return repository.findById(id);

    }

    public List<ModeDeplacement> ModesByLibelle(String modeDeplacement){
        List<ModeDeplacement> modes = new ArrayList<>();
        repository.findByModeDeplacement(modeDeplacement).forEach(modes::add);

        return modes;
    }

    public ModeDeplacement NewMode(ModeDeplacement mode){
        mode.setStatut(true);
        return repository.save(mode);
    }

    public ModeDeplacement updateModeDeplacement(Integer id, ModeDeplacement newmode){
        
        ModeDeplacement realMD = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Mode de déplacement" + id + "nexiste pas"));
        if(newmode.getModeDeplacement()!= null){
            realMD.setModeDeplacement(newmode.getModeDeplacement());;

        }
        if(newmode.getStatut()!= null){
            realMD.setStatut(newmode.getStatut());;

        } 
               
        return repository.save(realMD);

    } 

    public ModeDeplacement deleteMode(Integer id){
        ModeDeplacement realMD = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Mode de déplacement" + id + "nexiste pas"));
        realMD.setStatut(false);
        return repository.save(realMD);
    }
}
