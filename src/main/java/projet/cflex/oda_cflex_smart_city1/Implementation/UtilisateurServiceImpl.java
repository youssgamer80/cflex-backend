package projet.cflex.oda_cflex_smart_city1.Implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.cflex.oda_cflex_smart_city1.Model.Utilisateur;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import projet.cflex.oda_cflex_smart_city1.Repository.UtilisateurRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.VehiculeRepository;
import projet.cflex.oda_cflex_smart_city1.Service.UtilisateurService;

import javax.persistence.EntityManager;
import java.util.Collection;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j

public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private final UtilisateurRepository utilisateurRepository;
    @Autowired
    EntityManager entityManager;
    @Override
    public Utilisateur create(Utilisateur utilisateur) {
        log.info("Enregistrement d'un nouvel utilisateur: {}","Nom d'utilisateur:"+" "+utilisateur.getNomUtilisateur()+"/n"+
                "Role:"+" "+utilisateur.getRole());

        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Collection<Utilisateur> list(boolean isDeleted) {
        log.info("Tous les utilisateurs");
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedUtilisateurFilter");
        filter.setParameter("isDeleted", isDeleted);
        Collection<Utilisateur> utilisateurs =  utilisateurRepository.findAll();
        session.disableFilter("deletedUtilisateurFilter");
        return utilisateurs;
    }

    @Override
    public Utilisateur get(Integer id) {
        log.info("Recherche par utilisateur:{}",id);
        return utilisateurRepository.findById(id).get();
    }


    @Override
    public Boolean delete(Integer id) {
        log.info("Suppression d'un utilisateur par ID: {}",id);
        utilisateurRepository.deleteById(id);
        return TRUE;
    }
}
