package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.internal.util.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Controller.Ligne_Point_ArretObject;
import projet.cflex.oda_cflex_smart_city1.Model.LignePointArret;
import projet.cflex.oda_cflex_smart_city1.Model.PointArret;
import projet.cflex.oda_cflex_smart_city1.Model.Ligne;
import projet.cflex.oda_cflex_smart_city1.Repository.LignePointArretRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.LigneRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.PointArretRepository;

@Service
public class LignePointArretService {

    @Autowired
    public LignePointArretRepository ligne_Point_ArretRepository;

    @Autowired
    private LigneRepository ligneRepository;

    @Autowired
    private PointArretRepository pointArretRepository;

    private static Boolean statut = true;

    public List<LignePointArret> getAllLignesPointArret() {

        List<LignePointArret> lignes = new ArrayList<>();

        ligne_Point_ArretRepository.findByStatutJPQL(statut).forEach(lignes::add);

        return lignes;
    }

    public LignePointArret addLignePointArret(Ligne_Point_ArretObject ligne_Point_ArretObject) {

<<<<<<< HEAD:src/main/java/projet/cflex/oda_cflex_smart_city1/Service/LignePointArretService.java
        LignePointArret ligne_Point_Arret = new LignePointArret();
        addlignePA(ligne_Point_ArretObject, ligne_Point_Arret);

        return ligne_Point_ArretRepository.save(ligne_Point_Arret);
    }


    public  void addlignePA(Ligne_Point_ArretObject ligne_Point_ArretObject, LignePointArret ligne_Point_Arret){

=======
>>>>>>> eb52bef35c493dd7f34a0554bf46fdee3f6796da:src/main/java/projet/cflex/oda_cflex_smart_city1/Service/Ligne_Point_ArretService.java
        Ligne ligne = ligneRepository.findLigne(ligne_Point_ArretObject.idLigneFk);

        Integer nbPointArret = ligne_Point_ArretObject.idPointArretFk.length;

        for (int i = 0; i < nbPointArret - 1; ++i) {

            System.out.println(ligne_Point_ArretObject.idPointArretFk[i]);
            Ligne_Point_Arret ligne_Point_Arret = new Ligne_Point_Arret();
            PointArret pointArret = pointArretRepository.findPointArret(ligne_Point_ArretObject.idPointArretFk[i]);

            ligne_Point_Arret.setIdPointArretFk(pointArret);
            ligne_Point_Arret.setIdLigneFk(ligne);
            ligne_Point_Arret.setStatut(true);
            ligne_Point_Arret.setRang(i + 1);
            ligne_Point_ArretRepository.save(ligne_Point_Arret);
        }

        System.out.println(ligne_Point_ArretObject.idPointArretFk[nbPointArret - 1]);
        Ligne_Point_Arret ligne_Point_Arret = new Ligne_Point_Arret();

        PointArret pointArret = pointArretRepository
                .findPointArret(ligne_Point_ArretObject.idPointArretFk[nbPointArret - 1]);

        ligne_Point_Arret.setIdPointArretFk(pointArret);
        ligne_Point_Arret.setIdLigneFk(ligne);
        ligne_Point_Arret.setStatut(true);
        ligne_Point_Arret.setRang(nbPointArret);

        return ligne_Point_ArretRepository.save(ligne_Point_Arret);
    }

<<<<<<< HEAD:src/main/java/projet/cflex/oda_cflex_smart_city1/Service/LignePointArretService.java
    public List<LignePointArret> getByIdLigne(Integer idligne) {
    System.out.print(idligne);
    // Ligne ligne = ligneRepository.findLigne(idligne);
    
    return ligne_Point_ArretRepository.findByIdligne(idligne);
    }

 
    public String deleteLigne_Point_Arrets(Ligne_Point_ArretObject ligne_Point_ArretObject){
=======
    public List<Ligne_Point_Arret> getByIdLigne(Integer idligne) {
        System.out.print(idligne);
        // Ligne ligne = ligneRepository.findLigne(idligne);
>>>>>>> eb52bef35c493dd7f34a0554bf46fdee3f6796da:src/main/java/projet/cflex/oda_cflex_smart_city1/Service/Ligne_Point_ArretService.java

        return ligne_Point_ArretRepository.findByIdligne(idligne);
    }

    public String updateLigne_Point_Arrets(Ligne_Point_ArretObject ligne_Point_ArretObject) {

        Ligne ligne = ligneRepository.findLigne(ligne_Point_ArretObject.idLigneFk);

        // Integer rang ;

        List<Ligne_Point_Arret> ligne_Point_Arret = ligne_Point_ArretRepository
                .findByIdligne(ligne_Point_ArretObject.idLigneFk);

        // System.out.println(ligne_Point_ArretRepository.findByIdligne(ligne_Point_ArretObject.idLigneFk).size());

        for (Ligne_Point_Arret item : ligne_Point_Arret) {

            // System.out.print("Element ");
            // System.out.println(item.getIdPointArretFk().getId());
            item.setStatut(false);
            item.setRang(0);
            // System.out.println(item.getStatut());
            ligne_Point_ArretRepository.save(item);
            // System.out.print("--------------------------------- ");
        }

        Boolean trouve = false;
        Integer rang=0;
        for (Integer idpoint : ligne_Point_ArretObject.idPointArretFk) {
            System.out.print("IDPOINT ");
            System.out.println(idpoint);

            for (Ligne_Point_Arret item : ligne_Point_Arret) {

            if (idpoint == item.getIdPointArretFk().getId()) {
            trouve = true;
            rang++;
            System.out.println("POINT ARRÊT EXISTANT");
            item.setStatut(true);
            item.setRang(rang);
            ligne_Point_ArretRepository.save(item);

            }

            }

            if (!trouve) {

                Ligne_Point_Arret ligne_Point_Arrett = new Ligne_Point_Arret();

                PointArret pointArret = pointArretRepository
                        .findPointArret(idpoint);

                ligne_Point_Arrett.setIdPointArretFk(pointArret);
                ligne_Point_Arrett.setIdLigneFk(ligne);
                ligne_Point_Arrett.setStatut(true);
                ligne_Point_Arrett.setRang(rang+1);
                ligne_Point_ArretRepository.save(ligne_Point_Arrett);

            }
            trouve = false;

        }

        return "Modifié";
    }

}
