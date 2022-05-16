package projet.cflex.oda_cflex_smart_city1.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Proprietaire;
import projet.cflex.oda_cflex_smart_city1.Repository.ProprietaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietaireService {

    @Autowired
    ProprietaireRepository proprietaireRepository;
    public void save (Proprietaire proprietaire){proprietaireRepository.save(proprietaire);}
    public List<Proprietaire> findAll(){
        return  proprietaireRepository.findAll();
    }
    public Optional<Proprietaire> findOne(Integer id){
        return  proprietaireRepository.findById(id);
    }

    public void delete(Integer id){
        proprietaireRepository.deleteById(id);
    }

}
