package projet.cflex.oda_cflex_smart_city1.Implementation;

import projet.cflex.oda_cflex_smart_city1.Model.Proprietaire;
import projet.cflex.oda_cflex_smart_city1.Repository.ProprietaireRepository;
import projet.cflex.oda_cflex_smart_city1.Service.ProprioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Random;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j

public class ProprietaireServiceImpl implements ProprioService {

    @Autowired
    private final ProprietaireRepository proprietaireRepository;
    @Autowired
    EntityManager entityManager;
    @Override
    public Proprietaire create(Proprietaire proprietaire) {
        log.info("Enregistrement d'un nouveau propriétaire: {}","Nom:"+" "+proprietaire.getNom()+"/"+
                        "Prénoms:"+" "+proprietaire.getPrenom());
       /* proprietaire.setPermis(setProprietairePermis());
        proprietaire.setPieceIdentite(setProprietairePieceIdentite());*/
        return proprietaireRepository.save(proprietaire);
    }

    @Override
    public Collection<Proprietaire> list(boolean isDeleted) {
        log.info("Tous les proprios");
        //return proprietaireRepository.findAll(Example.of(0,id)).toList;
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedProprietaireFilter");
        filter.setParameter("isDeleted", isDeleted);
        Collection<Proprietaire> proprietaires =  proprietaireRepository.findAll();
        session.disableFilter("deletedProprietaireFilter");
        return proprietaires;
    }

    @Override
    public Proprietaire get(Integer id) {
        log.info("Recherche par proprietaire:{}",id);
        return proprietaireRepository.findById(id).get();
    }

    @Override
    public Boolean delete(Integer id) {
        log.info("Suppression d'un propriétaire par ID: {}",id);
        proprietaireRepository.deleteById(id);
        return TRUE;
    }
    private String setProprietairePieceIdentite() {

        String[] pieceidentiteproprio = {"pieceidentite1.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().
                path(("/proprietaire/pieceidentite"+ pieceidentiteproprio[new Random().nextInt(4)])).toUriString();
    }
    private String setProprietairePermis() {
        String[] permisproprio = {"permis1.png"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().
                path(("/proprietaire/permis"+ permisproprio[new Random().nextInt(4)])).toUriString();
    }

    public Proprietaire majProprietaire(Integer id, Proprietaire proprietaire) {

        Proprietaire existingproprio = this.proprietaireRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce proprietaire n'existe pas :" + id));

        if(proprietaire.getNom()!=null){
            existingproprio.setNom(proprietaire.getNom());
        }

        if(proprietaire.getPrenom()!=null){
            existingproprio.setPrenom(proprietaire.getPrenom());
        }

        if(proprietaire.getTelephone()!=null){
            existingproprio.setTelephone(proprietaire.getTelephone());
        }

        if(proprietaire.getEmail()!=null){
            existingproprio.setEmail(proprietaire.getEmail());
        }

        if(proprietaire.getPieceIdentite()!=null){
            existingproprio.setPieceIdentite(proprietaire.getPieceIdentite());
        }

        if(proprietaire.getStatut()!=null){
            existingproprio.setStatut(proprietaire.getStatut());
        }

        if(proprietaire.getPermis()!=null){
            existingproprio.setPermis(proprietaire.getPermis());
        }

        if(proprietaire.getGenre()!=null){
            existingproprio.setGenre(proprietaire.getGenre());
        }

        if(proprietaire.getDateNaissance()!=null){
            existingproprio.setDateNaissance(proprietaire.getDateNaissance());
        }

        if(proprietaire.getLieuNaissance()!=null){
            existingproprio.setLieuNaissance(proprietaire.getLieuNaissance());
        }

        if(proprietaire.getLieuResidence()!=null){
            existingproprio.setLieuResidence(proprietaire.getLieuResidence());
        }

        return proprietaireRepository.save(existingproprio);
    }
}
