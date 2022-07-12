package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.internal.util.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Controller.LitigeObject;
import projet.cflex.oda_cflex_smart_city1.Model.Litige;
import projet.cflex.oda_cflex_smart_city1.Model.Usager;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import projet.cflex.oda_cflex_smart_city1.Model.Litige;
import projet.cflex.oda_cflex_smart_city1.Model.Zone;
import projet.cflex.oda_cflex_smart_city1.Repository.LitigeRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.UsagerRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.VehiculeRepository;

@Service
public class LitigeService {

    @Autowired
    public  LitigeRepository litigeRepository;

    @Autowired
    private UsagerRepository usagerRepository;
 
    @Autowired
    private VehiculeRepository vehiculeRepository;

    // private static Boolean statut = true;

    public  List<Litige> getAllLitige() {

        List<Litige> litige = new ArrayList<>();

        litigeRepository.findAll().forEach(litige::add);

        return litige;
    }

    public Litige addLitige(LitigeObject litigeObject) {

        System.out.println("LITIGE OBJECT");
        System.out.println(litigeObject.description);

       
        Usager usager = usagerRepository.findUsagerById(litigeObject.idUsagerFk);

        // System.out.println("VEHICULE");
        // System.out.println(vehicule);

        // System.out.println("USAGER");
        // System.out.println(usager);

        Litige litige = new Litige();

        litige.setLibelle(litigeObject.libelle);
        litige.setDescription(litigeObject.description);
    
        litige.setIdUsagerFk(usager);

        return litigeRepository.save(litige);
    }

    public List<Litige> getByVehicule(Integer IdVehicule) {
        System.out.print(IdVehicule);
        return litigeRepository.findByIdVehicule(IdVehicule);
    }

    public  List<Litige> getByUsager(Integer IdUsager) {
        System.out.print(IdUsager);
        return litigeRepository.findByIdUsager(IdUsager);
    }


    // public Ligne getLigneBydId(Integer id) {
    //     // System.out.print(id);
    //     return ligneRepository.findLigne(id);
    // }

    // public Ligne updateLigne(Integer id, LigneObject ligneObject) {

    //     Ligne existingLigne = ligneRepository.findById(id)
    //             .orElseThrow(() -> new ResourceNotFoundException("Type Transport not foundwith id :" + id));

    //     if (ligneObject.nom != null) {
    //         existingLigne.setNom(ligneObject.nom);
    //     }

    //     if (ligneObject.depart != null) {
    //         existingLigne.setDepart(ligneObject.depart);
    //     }

    //     if (ligneObject.arrivee != null) {
    //         existingLigne.setArrivee(ligneObject.arrivee);
    //     }

   

    //     if (ligneObject.idZoneFk != null) {
    //         Zone zone = zoneRepository.findZone(ligneObject.idZoneFk);

    //         existingLigne.setIdZoneFk(zone);
    //     }

    //     if (ligneObject.depart_longitude != 0L) {
           
    //         existingLigne.setDepart_longitude(ligneObject.depart_longitude);
    //     }

    //     if (ligneObject.depart_latitude != 0L) {
           
    //         existingLigne.setDepart_latitude(ligneObject.depart_latitude);
    //     }

    //     if (ligneObject.arrivee_longitude != 0L) {
           
    //         existingLigne.setArrivee_longitude(ligneObject.arrivee_longitude);
    //     }

    //     if (ligneObject.arrivee_latitude != 0L) {
           
    //         existingLigne.setArrivee_latitude(ligneObject.arrivee_latitude);
    //     }


    //     existingLigne.setStatut(true);

    //     return ligneRepository.save(existingLigne);
    // }

    // public Ligne deleteLigne(Integer id) {

    //     Ligne existingLigne = ligneRepository.findById(id)
    //             .orElseThrow(() -> new ResourceNotFoundException("Type transport not foundwith id :" + id));
    //     existingLigne.setStatut(false);
    //     return ligneRepository.save(existingLigne);
    // }
    
    // public static List<Ligne> getAllTroncon() {

    //     List<Ligne> lignes = new ArrayList<>();

    //     ligneRepository.findByStatutJPQL(statut).forEach(lignes::add);
        
    //     return lignes;

    // }
    
}

