package projet.cflex.oda_cflex_smart_city1.Service;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import projet.cflex.oda_cflex_smart_city1.Model.Demande;
public interface IDemande {
 
        List<Demande> getAllDemandes();
        Optional<Demande> findById(int id);

        Demande save(Demande std);
        void deleteById(int id);
}
