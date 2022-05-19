package projet.cflex.oda_cflex_smart_city1.Service;
import projet.cflex.oda_cflex_smart_city1.Model.Demande;

import java.util.List;
import java.util.Optional;

public interface IDemande {
 
        List<Demande> getAllDemandes();
        Optional<Demande> findById(int id);

        Demande save(Demande std);
        void deleteById(int id);
}
