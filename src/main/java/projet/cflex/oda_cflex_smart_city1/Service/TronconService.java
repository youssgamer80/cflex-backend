package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Controller.LigneObject;
import projet.cflex.oda_cflex_smart_city1.Model.Troncon;
import projet.cflex.oda_cflex_smart_city1.Repository.TronconRepository;

@Service
public class TronconService {

    @Autowired
    public TronconRepository tronconRepository;

    // @Autowired
    // private TypeTransportRepository typeTransportRepository;
    // @Autowired
    // private ZoneRepository zoneRepository;

    private Boolean statut = true;

    // public List<Ligne> getAllLignes() {

    //     List<Ligne> lignes = new ArrayList<>();

    //     ligneRepository.findByStatutJPQL(statut).forEach(lignes::add);

    //     return lignes;
    // }

    // public Ligne addLigne(LigneObject ligneObject) {

    //     TypeTransport typeTransport = typeTransportRepository.findTypeTransport(ligneObject.idTypeTransportFk);
    //     Zone zone = zoneRepository.findZone(ligneObject.idZoneFk);

    //     // System.out.print(ligneObject.nom);
    //     // System.out.print(ligneObject.depart);
    //     // System.out.print(ligneObject.arrivee);

    //     Ligne ligne = new Ligne();

    //     ligne.setNom(ligneObject.nom);
    //     ligne.setDepart(ligneObject.depart);
    //     ligne.setArrivee(ligneObject.arrivee);
    //     ligne.setIdTypeTransportFk(typeTransport);
    //     ligne.setIdZoneFk(zone);
    //     ligne.setStatut(true);

    //     return ligneRepository.save(ligne);
    // }

    // public Ligne getLigne(String nomLigne) {
    //     System.out.print(nomLigne);
    //     return ligneRepository.findByNom(nomLigne);
    // }

    // public Ligne updateLigne(Integer id, LigneObject ligneObject) {

    //     Ligne existingLigne = this.ligneRepository.findById(id)
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

    //     if (ligneObject.idTypeTransportFk != null) {
    //         TypeTransport typeTransport = typeTransportRepository.findTypeTransport(ligneObject.idTypeTransportFk);

    //         existingLigne.setIdTypeTransportFk(typeTransport);
    //     }

    //     if (ligneObject.idZoneFk != null) {
    //         Zone zone = zoneRepository.findZone(ligneObject.idZoneFk);

    //         existingLigne.setIdZoneFk(zone);
    //     }

    //     existingLigne.setStatut(true);

    //     return ligneRepository.save(existingLigne);
    // }

    // public Ligne deleteLigne(Integer id) {

    // Ligne existingLigne = this.ligneRepository.findById(id)
    // .orElseThrow(() -> new ResourceNotFoundException("Type transport not foundwith id :" + id));
    // existingLigne.setStatut(false);
    // return ligneRepository.save(existingLigne);
    // }


    public Troncon detacherLigne(Integer id) {

        Troncon existingTroncon = this.tronconRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Troncon not foundwith id :" + id));
        existingTroncon.setIdLigneFk(null);
        return tronconRepository.save(existingTroncon);
        }
}
