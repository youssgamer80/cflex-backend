package projet.cflex.oda_cflex_smart_city1.Implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.cflex.oda_cflex_smart_city1.Model.Borne;
import projet.cflex.oda_cflex_smart_city1.Repository.BorneRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.ProprietaireRepository;
import projet.cflex.oda_cflex_smart_city1.Service.BorneService;
import projet.cflex.oda_cflex_smart_city1.exception.ResourceNotFoundException;

import javax.persistence.EntityManager;
import java.util.Collection;
import static java.lang.Boolean.TRUE;

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

        log.info("Toute les bornes");
        //return proprietaireRepository.findAll(Example.of(0,id)).toList;
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedBorneFilter");
        filter.setParameter("isDeleted", isDeleted);
        Collection<Borne> bornes =  borneRepository.findAll();
        session.disableFilter("deletedBorneFilter");
        return bornes;
    }

    @Override
    public Borne get(Integer id) {
        log.info("Recherche par borne:{}",id);
        return borneRepository.findById(id).get();
    }

    @Override
    public Boolean delete(Integer id) {
        log.info("Suppression d'une borne par ID: {}",id);
        borneRepository.deleteById(id);
        return TRUE;
    }

    public Borne majBorne(Integer id, Borne borne) {

        Borne existingborne = this.borneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cette borne n'existe pas :" + id));

        if(borne.getLibelle()!=null){
            existingborne.setLibelle(borne.getLibelle());
        }

        if(borne.getStatut()!=null){
            existingborne.setStatut(borne.getStatut());
        }

        if(borne.getIdPointArretFk()!=null){
            existingborne.setIdPointArretFk(borne.getIdPointArretFk());
        }

        return borneRepository.save(existingborne);
    }
}
