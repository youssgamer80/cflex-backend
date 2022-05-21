package projet.cflex.oda_cflex_smart_city1.Implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.cflex.oda_cflex_smart_city1.Model.Stationner;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import projet.cflex.oda_cflex_smart_city1.Repository.StationnerRepository;
import projet.cflex.oda_cflex_smart_city1.Service.StationnerService;
import javax.persistence.EntityManager;

import java.util.Collection;
@RequiredArgsConstructor
@Service
@Transactional
@Slf4j

public class StationnerServiceImpl implements StationnerService {
    @Autowired
    StationnerRepository stationnerRepository;
    @Autowired
    EntityManager entityManager;

    @Override
    public Collection<Stationner> list(boolean isDeleted) {
        log.info("Liste des stationnements");
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedStationnementFilter");
        filter.setParameter("isDeleted", isDeleted);
        Collection<Stationner> stationnements =  stationnerRepository.findAll();
        session.disableFilter("deletedStationnementFilter");
        return stationnements;
    }
}
