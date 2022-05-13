package projet.cflex.oda_cflex_smart_city1.Service;


import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Demande;
import projet.cflex.oda_cflex_smart_city1.Repository.DemandeRepository;

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
    public Demande save(Demande std) {
        // TODO Auto-generated method stub
        return demanderepo.save(std);
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        demanderepo.deleteById(id);
    }
}
