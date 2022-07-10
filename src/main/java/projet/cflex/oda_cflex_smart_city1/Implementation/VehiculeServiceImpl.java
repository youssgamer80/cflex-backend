package projet.cflex.oda_cflex_smart_city1.Implementation;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import projet.cflex.oda_cflex_smart_city1.Repository.VehiculeRepository;
import projet.cflex.oda_cflex_smart_city1.Service.VehiculeService;

import javax.persistence.EntityManager;
import java.util.Collection;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j

public class VehiculeServiceImpl implements VehiculeService {
    @Autowired
    private final VehiculeRepository vehiculeRepository;
    @Autowired
    EntityManager entityManager;
    @Override
    public Vehicule create(Vehicule vehicule) {
        log.info("Enregistrement d'un nouveau vehicule: {}","Marque:"+" "+vehicule.getMarque()+"/n"+
                "Modele:"+" "+vehicule.getModele());
        System.out.println("hum"+vehicule.getImmatriculation());

        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Collection<Vehicule> list(boolean isDeleted) {
        log.info("Tous les vehicules");
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedVehiculeFilter");
        filter.setParameter("isDeleted", isDeleted);
        Collection<Vehicule> vehicules =  vehiculeRepository.findAllVehicule();
        session.disableFilter("deletedVehiculeFilter");
        return vehicules;
    }

    @Override
    public Vehicule get(Integer id) {
        log.info("Recherche par vehicule:{}",id);
        return vehiculeRepository.findById(id).get();
    }


    @Override
    public Boolean delete(Integer id) {
        log.info("Suppression d'un vehicule par ID: {}",id);
        vehiculeRepository.deleteById(id);
        return TRUE;
    }

}
