package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.internal.util.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Controller.LigneObject;
import projet.cflex.oda_cflex_smart_city1.Model.Ligne;
import projet.cflex.oda_cflex_smart_city1.Model.PointArret;
// import projet.cflex.oda_cflex_smart_city1.Model.TypeTransport;
import projet.cflex.oda_cflex_smart_city1.Model.Zone;
import projet.cflex.oda_cflex_smart_city1.Repository.LigneRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.PointArretRepository;
// import projet.cflex.oda_cflex_smart_city1.Repository.TypeTransportRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.ZoneRepository;

@Service
public class LigneService {

    @Autowired
    public  LigneRepository ligneRepository;

    // @Autowired
    // private TypeTransportRepository typeTransportRepository;
    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    public PointArretRepository pointArretRepository;

    private static Boolean statut = true;

    public  List<Ligne> getAllLignes() {

        List<Ligne> lignes = new ArrayList<>();

        ligneRepository.findByStatutJPQL(statut).forEach(lignes::add);

        return lignes;
    }

    public Ligne addLigne(LigneObject ligneObject) {


    
        // TypeTransport typeTransport = typeTransportRepository.findTypeTransport(ligneObject.idTypeTransportFk);
        Zone zone = zoneRepository.findZone(ligneObject.idZoneFk);
        PointArret depart = pointArretRepository.findPointArret(ligneObject.idDepartFk);
        PointArret arrivee = pointArretRepository.findPointArret(ligneObject.idArriveeFk);

        
        Ligne ligne = new Ligne();

        ligne.setNom(ligneObject.nom);
        ligne.setIdDepartFk(depart);
        ligne.setIdArriveeFk(arrivee);
        ligne.setTarif(ligneObject.tarif);

        
        // ligne.setIdTypeTransportFk(typeTransport);
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

        if (ligneObject.idDepartFk != null) {
            PointArret depart = pointArretRepository.findPointArret(ligneObject.idDepartFk);

            existingLigne.setIdDepartFk(depart);
        }
        if (ligneObject.idArriveeFk != null) {
            PointArret arrivee = pointArretRepository.findPointArret(ligneObject.idArriveeFk);

            existingLigne.setIdArriveeFk(arrivee);
        }

        // if (ligneObject.idTypeTransportFk != null) {
        //     TypeTransport typeTransport = typeTransportRepository.findTypeTransport(ligneObject.idTypeTransportFk);

        //     existingLigne.setIdTypeTransportFk(typeTransport);
        // }

        if (ligneObject.idZoneFk != null) {
            Zone zone = zoneRepository.findZone(ligneObject.idZoneFk);

            existingLigne.setIdZoneFk(zone);
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

