package projet.cflex.oda_cflex_smart_city1.Implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.cflex.oda_cflex_smart_city1.Model.Borne;
import projet.cflex.oda_cflex_smart_city1.Repository.BorneRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.ProprietaireRepository;
import projet.cflex.oda_cflex_smart_city1.Service.BorneService;

import javax.persistence.EntityManager;
import java.util.Collection;
@RequiredArgsConstructor
@Service
@Transactional
@Slf4j

public class BorneServiceImpl implements BorneService {
    @Autowired
    private final BorneRepository borneRepository;
    @Autowired
    EntityManager entityManager;
    @Override
    public Borne create(Borne borne) {
        log.info("Enregistrement d'une nouvelle borne: {}","Libelle:"+" "+borne.getLibelle());
        return borneRepository.save(borne);
    }

    @Override
    public Collection<Borne> list(boolean isDeleted) {

        return null;
    }

    @Override
    public Borne get(Integer id) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    @Override
    public Borne majBorne(Integer id, Borne borne) {
        return null;
    }
}
