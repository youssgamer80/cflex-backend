package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.internal.util.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Controller.LigneObject;
import projet.cflex.oda_cflex_smart_city1.Model.Ligne;
import projet.cflex.oda_cflex_smart_city1.Model.TypeTransport;
import projet.cflex.oda_cflex_smart_city1.Model.Zone;
import projet.cflex.oda_cflex_smart_city1.Repository.LigneRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.TypeTransportRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.ZoneRepository;

@Service
public class LigneService {

    @Autowired
    public  LigneRepository ligneRepository;

    @Autowired
    private TypeTransportRepository typeTransportRepository;
    @Autowired
    private ZoneRepository zoneRepository;

    private static Boolean statut = true;

    public  List<Ligne> getAllLignes() {

        List<Ligne> lignes = new ArrayList<>();

        ligneRepository.findByStatutJPQL(statut).forEach(lignes::add);

        return lignes;
    }

    public Ligne addLigne(LigneObject ligneObject) {

        TypeTransport typeTransport = typeTransportRepository.findTypeTransport(ligneObject.idTypeTransportFk);
        Zone zone = zoneRepository.findZone(ligneObject.idZoneFk);

        // System.out.print(ligneObject.nom);
        // System.out.print(ligneObject.depart);
        // System.out.print(ligneObject.arrivee);

        Ligne ligne = new Ligne();

        ligne.setNom(ligneObject.nom);
        ligne.setDepart(ligneObject.depart);
        ligne.setArrivee(ligneObject.arrivee);

        ligne.setDepart_longitude(ligneObject.depart_longitude);
        ligne.setDepart_latitude(ligneObject.depart_latitude);
        
        ligne.setArrivee_longitude(ligneObject.arrivee_latitude);
        ligne.setArrivee_latitude(ligneObject.arrivee_latitude);

        
        ligne.setIdTypeTransportFk(typeTransport);
        ligne.setIdZoneFk(zone);
        ligne.setStatut(true);

        return ligneRepository.save(ligne);
    }

    public Ligne getLigne(String nomLigne) {
        System.out.print(nomLigne);
        return ligneRepository.findByNom(nomLigne);
    }

    public Ligne getLigneBydId(Integer id) {
        // System.out.print(id);
        return ligneRepository.findLigne(id);
    }

    public Ligne updateLigne(Integer id, LigneObject ligneObject) {

        Ligne existingLigne = ligneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Type Transport not foundwith id :" + id));

        if (ligneObject.nom != null) {
            existingLigne.setNom(ligneObject.nom);
        }

        if (ligneObject.depart != null) {
            existingLigne.setDepart(ligneObject.depart);
        }

        if (ligneObject.arrivee != null) {
            existingLigne.setArrivee(ligneObject.arrivee);
        }

        if (ligneObject.idTypeTransportFk != null) {
            TypeTransport typeTransport = typeTransportRepository.findTypeTransport(ligneObject.idTypeTransportFk);

            existingLigne.setIdTypeTransportFk(typeTransport);
        }

        if (ligneObject.idZoneFk != null) {
            Zone zone = zoneRepository.findZone(ligneObject.idZoneFk);

            existingLigne.setIdZoneFk(zone);
        }

        if (ligneObject.depart_longitude != 0L) {
           
            existingLigne.setDepart_longitude(ligneObject.depart_longitude);
        }

        if (ligneObject.depart_latitude != 0L) {
           
            existingLigne.setDepart_latitude(ligneObject.depart_latitude);
        }

        if (ligneObject.arrivee_longitude != 0L) {
           
            existingLigne.setArrivee_longitude(ligneObject.arrivee_longitude);
        }

        if (ligneObject.arrivee_latitude != 0L) {
           
            existingLigne.setArrivee_latitude(ligneObject.arrivee_latitude);
        }


        existingLigne.setStatut(true);

        return ligneRepository.save(existingLigne);
    }

    public Ligne deleteLigne(Integer id) {

        Ligne existingLigne = ligneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Type transport not foundwith id :" + id));
        existingLigne.setStatut(false);
        return ligneRepository.save(existingLigne);
    }
    
    // public static List<Ligne> getAllTroncon() {

    //     List<Ligne> lignes = new ArrayList<>();

    //     ligneRepository.findByStatutJPQL(statut).forEach(lignes::add);
        
    //     return lignes;

    // }
    
}
