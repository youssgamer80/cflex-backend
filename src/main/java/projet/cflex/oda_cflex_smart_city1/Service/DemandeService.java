package projet.cflex.oda_cflex_smart_city1.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Repository.DemandeRepository;

/**
 * Classe demandeService pour servir de pont entre le model et le logique métier
 * @author Yao Eloge
 */
@Service
public class DemandeService implements IDemande {
    DemandeRepository demanderepo;
    @Autowired
    public DemandeService(DemandeRepository demanderepo) {
        this.demanderepo = demanderepo;
    }
    @Override
    public List<Demande> getAllDemandes() {
        // TODO Auto-generated method stub
        return demanderepo.findAll();
    }

    @Override
    public Optional<Demande> findById(int id) {
        // TODO Auto-generated method stub
        return demanderepo.findById(id);
    }


    @Override
    public Demande save(Demande demande) {
        // TODO Auto-generated method stub
        return demanderepo.save(demande);
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        demanderepo.deleteById(id);
    }
}
