package projet.cflex.oda_cflex_smart_city1.Implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projet.cflex.oda_cflex_smart_city1.Model.Proprietaire;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import projet.cflex.oda_cflex_smart_city1.Repository.VehiculeRepository;
import projet.cflex.oda_cflex_smart_city1.Service.VehiculeService;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Random;

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
        log.info("Enregistrement d'un nouveau propriétaire: {}","Marque:"+" "+vehicule.getMarque()+"/"+
                "Prénoms:"+" "+vehicule.getModele());
        vehicule.setCarteGrise(setVehiculeCarteGrise());
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Collection<Vehicule> list(boolean isDeleted) {
        log.info("Tous les vehicule");
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedVehiculeFilter");
        filter.setParameter("isDeleted", isDeleted);
        Collection<Vehicule> vehicules =  vehiculeRepository.findAll();
        session.disableFilter("deletedVehiculeFilter");
        return vehicules;
    }

    @Override
    public Vehicule get(Integer id) {
        log.info("Recherche par vehicule:{}",id);
        return vehiculeRepository.findById(id).get();
    }

    @Override
    public Vehicule update(Integer id, Vehicule vehicule) {
        log.info("Modification d'un vehicule: {}",id);
        Vehicule exvehicule = this.vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce véhicule n'existe pas :" + id));
        return vehiculeRepository.save(exvehicule);

    }

    @Override
    public Boolean delete(Integer id) {
        log.info("Suppression d'un vehicule par ID: {}",id);
        vehiculeRepository.deleteById(id);
        return TRUE;
    }



    private String setVehiculeCarteGrise() {
        String[] pieceidentiteproprio = {"pieceidentite1.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().
                path(("/proprietaire/pieceidentite"+ pieceidentiteproprio[new Random().nextInt(4)])).toUriString();
    }
}
