package projet.cflex.oda_cflex_smart_city1.Implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.cflex.oda_cflex_smart_city1.Model.Trackergps;
import projet.cflex.oda_cflex_smart_city1.Repository.TrackergpsRepository;
import projet.cflex.oda_cflex_smart_city1.Service.TrackergpsService;
import projet.cflex.oda_cflex_smart_city1.exception.ResourceNotFoundException;

import javax.persistence.EntityManager;
import java.util.Collection;
import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j

public class TrackergpsServiceImpl implements TrackergpsService {
    
    @Autowired
    private final TrackergpsRepository trackergpsRepository;
    @Autowired
    EntityManager entityManager;
    @Override
    public Trackergps create(Trackergps trackergps) {
        log.info("Enregistrement d'un nouveau trackergps: {}","Libelle:"+" "+trackergps.getLibelle());
        // trackergps.setStatut(true);
        return trackergpsRepository.save(trackergps);
    }

    @Override
    public Collection<Trackergps> list(boolean isDeleted) {

        log.info("Tous les trackergps");
        //return proprietaireRepository.findAll(Example.of(0,id)).toList;
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedTrackergpsFilter");
        filter.setParameter("isDeleted", isDeleted);
        Collection<Trackergps> trackergps =  trackergpsRepository.findAll();
        session.disableFilter("deletedTrackergpsFilter");
        return trackergps;
    }

    @Override
    public Trackergps get(Integer id) {
        log.info("Recherche par trackergps:{}",id);
        return trackergpsRepository.findById(id).get();
    }

    // @Override
    // public Trackergps getLibelle(String libelle) {
    //     log.info("Recherche par trackergps:{}",libelle);
    //     return trackergpsRepository.findByLibelle(libelle);
    // }

    @Override
    public Boolean delete(Integer id) {
        log.info("Suppression d'un trackergps par ID: {}",id);
        trackergpsRepository.deleteById(id);
        return TRUE;
    }

    public Trackergps majTrackergps(Integer id, Trackergps trackergps) {

        Trackergps existingtTrackergps = this.trackergpsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cet trackergps n'existe pas :" + id));

        if(trackergps.getLibelle()!=null){
            existingtTrackergps.setLibelle(trackergps.getLibelle());
        }

        if(trackergps.getIdVehiculeFk()!=null){
            existingtTrackergps.setIdVehiculeFk(trackergps.getIdVehiculeFk());
        }

        existingtTrackergps.setStatut(true);

        return trackergpsRepository.save(existingtTrackergps);
    }

    
}
