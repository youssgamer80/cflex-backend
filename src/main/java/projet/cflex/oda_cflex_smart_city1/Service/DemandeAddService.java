package projet.cflex.oda_cflex_smart_city1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.DemandeAdd;
import projet.cflex.oda_cflex_smart_city1.Repository.DemandeAddRepository;

@Service
public class DemandeAddService {
    
    @Autowired
    public DemandeAddRepository demandeAddRepository;


    public DemandeAdd addDemande(DemandeAdd demandeAdd) {

        return demandeAddRepository.save(demandeAdd);
    }
}
