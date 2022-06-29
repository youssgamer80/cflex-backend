package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

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

        LignePointArret ligne_Point_Arret = new LignePointArret();
        addlignePA(ligne_Point_ArretObject, ligne_Point_Arret);

        return ligne_Point_ArretRepository.save(ligne_Point_Arret);
    }


    public  void addlignePA(Ligne_Point_ArretObject ligne_Point_ArretObject, LignePointArret ligne_Point_Arret){

        Ligne ligne = ligneRepository.findLigne(ligne_Point_ArretObject.idLigneFk);


        Integer nbPointArret = ligne_Point_ArretObject.idPointArretFk.length;

        for (int i = 0; i < nbPointArret-1; ++i) {

            System.out.println(ligne_Point_ArretObject.idPointArretFk[i]);
            // Ligne_Point_Arret ligne_Point_Arret = new Ligne_Point_Arret();
            PointArret pointArret = pointArretRepository.findPointArret(ligne_Point_ArretObject.idPointArretFk[i]);
           
            ligne_Point_Arret.setIdPointArretFk(pointArret);
            ligne_Point_Arret.setIdLigneFk(ligne);
            ligne_Point_Arret.setStatut(true);
            ligne_Point_Arret.setRang(i + 1);
            ligne_Point_ArretRepository.save(ligne_Point_Arret);
        }


        System.out.println(ligne_Point_ArretObject.idPointArretFk[nbPointArret-1]);
       
        PointArret pointArret = pointArretRepository.findPointArret(ligne_Point_ArretObject.idPointArretFk[nbPointArret-1]);
       
        ligne_Point_Arret.setIdPointArretFk(pointArret);
        ligne_Point_Arret.setIdLigneFk(ligne);
        ligne_Point_Arret.setStatut(true);
        ligne_Point_Arret.setRang(nbPointArret);
        ligne_Point_ArretRepository.save(ligne_Point_Arret);

    }
    

    public List<LignePointArret> getByIdLigne(Integer idligne) {
    System.out.print(idligne);
    // Ligne ligne = ligneRepository.findLigne(idligne);
    
    return ligne_Point_ArretRepository.findByIdligne(idligne);
    }

 
    public String deleteLigne_Point_Arrets(Ligne_Point_ArretObject ligne_Point_ArretObject){

        // System.out.printf("idligne", idligne);

        ligne_Point_ArretRepository.deleteById(17);
        
        return "Supprimé";
    }


    // public Ligne updateLigne(Integer id, LigneObject ligneObject) {

    // Ligne existingLigne = ligneRepository.findById(id)
    // .orElseThrow(() -> new ResourceNotFoundException("Type Transport not
    // foundwith id :" + id));

    // if (ligneObject.nom != null) {
    // existingLigne.setNom(ligneObject.nom);
    // }

    // if (ligneObject.depart != null) {
    // existingLigne.setDepart(ligneObject.depart);
    // }

    // if (ligneObject.arrivee != null) {
    // existingLigne.setArrivee(ligneObject.arrivee);
    // }

    // if (ligneObject.idTypeTransportFk != null) {
    // TypeTransport typeTransport =
    // typeTransportRepository.findTypeTransport(ligneObject.idTypeTransportFk);

    // existingLigne.setIdTypeTransportFk(typeTransport);
    // }

    // if (ligneObject.idZoneFk != null) {
    // Zone zone = zoneRepository.findZone(ligneObject.idZoneFk);

    // existingLigne.setIdZoneFk(zone);
    // }

    // if (ligneObject.depart_longitude != 0L) {

    // existingLigne.setDepart_longitude(ligneObject.depart_longitude);
    // }

    // if (ligneObject.depart_latitude != 0L) {

    // existingLigne.setDepart_latitude(ligneObject.depart_latitude);
    // }

    // if (ligneObject.arrivee_longitude != 0L) {

    // existingLigne.setArrivee_longitude(ligneObject.arrivee_longitude);
    // }

    // if (ligneObject.arrivee_latitude != 0L) {

    // existingLigne.setArrivee_latitude(ligneObject.arrivee_latitude);
    // }

    // existingLigne.setStatut(true);

    // return ligneRepository.save(existingLigne);
    // }

    // public Ligne deleteLigne(Integer id) {

    // Ligne existingLigne = ligneRepository.findById(id)
    // .orElseThrow(() -> new ResourceNotFoundException("Type transport not
    // foundwith id :" + id));
    // existingLigne.setStatut(false);
    // return ligneRepository.save(existingLigne);
    // }

    // public static List<Ligne> getAllTroncon() {

    // List<Ligne> lignes = new ArrayList<>();

    // ligneRepository.findByStatutJPQL(statut).forEach(lignes::add);

    // return lignes;

    // }

}
