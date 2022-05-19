package projet.cflex.oda_cflex_smart_city1.Implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import projet.cflex.oda_cflex_smart_city1.Repository.VehiculeRepository;
import projet.cflex.oda_cflex_smart_city1.Service.VehiculeService;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Optional;

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
        //vehicule.setCarteGrise(setVehiculeCarteGrise());
        System.out.println("hum"+vehicule.getImmatriculation());
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Collection<Vehicule> list(boolean isDeleted) {
        log.info("Tous les vehicules");
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedVehiculeFilter");
        filter.setParameter("isDeleted", isDeleted);
        Collection<Vehicule> vehicules =  vehiculeRepository.findAll();
        session.disableFilter("deletedVehiculeFilter");
        return vehicules;
    }


  /*  @Override
    public Optional<Vehicule> listvehiculeproprio(boolean isDeleted, Vehicule vehicule) {
        //log.info("Tous les vehicules d'un proprio",vehicule.getIdProprietaireFk());
        //String liste = String.valueOf(vehicule.getIdProprietaireFk().getId());
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedVehiculeFilter");
        filter.setParameter("isDeleted", isDeleted);
        Optional<Vehicule> vehiculesproprio =  vehiculeRepository.findById(vehicule.getIdProprietaireFk().getId());
        session.disableFilter("deletedVehiculeFilter");
        return vehiculesproprio;
    }
*/

    @Override
    public Vehicule get(Integer id) {
        log.info("Recherche par vehicule:{}",id);
        return vehiculeRepository.findById(id).get();
    }

    public Vehicule majVehicule(Integer id, Vehicule vehicule) {

        Vehicule existingvehicule = this.vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce vehicule n'existe pas :" + id));

        if(vehicule.getImmatriculation()!=null){
            existingvehicule.setImmatriculation(vehicule.getImmatriculation());
        }

        if(vehicule.getMarque()!=null){
            existingvehicule.setMarque(vehicule.getMarque());
        }

        if(vehicule.getModele()!=null){
            existingvehicule.setModele(vehicule.getModele());
        }

        if(vehicule.getCarteGrise()!=null){
            existingvehicule.setCarteGrise(vehicule.getCarteGrise());
        }

        return vehiculeRepository.save(existingvehicule);
    }

    @Override
    public Boolean delete(Integer id) {
        log.info("Suppression d'un vehicule par ID: {}",id);
        vehiculeRepository.deleteById(id);
        return TRUE;
    }



  /*  private String setVehiculeCarteGrise() {
        String[] pieceidentiteproprio = {"pieceidentite1.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().
                path(("/proprietaire/pieceidentite"+ pieceidentiteproprio[new Random().nextInt(4)])).toUriString();
    }*/
}
