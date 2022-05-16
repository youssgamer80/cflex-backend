package projet.cflex.oda_cflex_smart_city1.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import projet.cflex.oda_cflex_smart_city1.Repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class VehiculeService {
    @Autowired
    VehiculeRepository vehiculeRepository;
    public void save (Vehicule vehicule){vehiculeRepository.save(vehicule);}
    public List<Vehicule> findAll(){
        return  vehiculeRepository.findAll();
    }
    public Optional<Vehicule> findOne(Integer id){
        return  vehiculeRepository.findById(id);
    }
    public void delete(Integer id){
        vehiculeRepository.deleteById(id);
    }
}
