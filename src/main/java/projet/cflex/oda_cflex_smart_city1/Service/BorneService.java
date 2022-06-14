package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.internal.util.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Controller.BorneObject;
import projet.cflex.oda_cflex_smart_city1.Model.Borne;
// import projet.cflex.oda_cflex_smart_city1.Model.TypeTransport;
import projet.cflex.oda_cflex_smart_city1.Model.PointArret;
import projet.cflex.oda_cflex_smart_city1.Repository.BorneRepository;
// import projet.cflex.oda_cflex_smart_city1.Repository.TypeTransportRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.PointArretRepository;

@Service
public class BorneService {

    @Autowired
    public BorneRepository borneRepository;

    // @Autowired
    // private TypeTransportRepository typeTransportRepository;
    @Autowired
    private PointArretRepository pointArretRepository;

    private static Boolean statut = true;

    public List<Borne> getAllBornes() {

        List<Borne> bornes = new ArrayList<>();

        borneRepository.findByStatutJPQL(statut).forEach(bornes::add);

        return bornes;
    }

    public Borne addBorne(BorneObject borneObject) {

        // TypeTransport typeTransport =
        // typeTransportRepository.findTypeTransport(ligneObject.idTypeTransportFk);
        PointArret pointArret = pointArretRepository.findPointArret(borneObject.idPointArretFk);

        Borne borne = new Borne();

        borne.setLibelle(borneObject.libelle);
        borne.setIdPointArretFk(pointArret);

        return borneRepository.save(borne);
    }

    public Borne getBorne(String nomLigne) {
        System.out.print(nomLigne);
        return borneRepository.findByLibelle(nomLigne);
    }

    public Borne getBorneBydId(Integer id) {
        // System.out.print(id);
        return borneRepository.findBorne(id);
    }

    public Borne updateBorne(Integer id, BorneObject borneObject) {

        Borne existingBorne = borneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Type Transport not foundwith id :" + id));

        if (borneObject.libelle != null) {
            existingBorne.setLibelle(borneObject.libelle);
        }

        if (borneObject.idPointArretFk != null) {
            PointArret pointArret = pointArretRepository.findPointArret(borneObject.idPointArretFk);

            existingBorne.setIdPointArretFk(pointArret);
        }

        existingBorne.setStatut(true);

        return borneRepository.save(existingBorne);
    }

    public Borne deleteBorne(Integer id) {

        Borne existingBorne = borneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Type transport not foundwith id :" + id));
        existingBorne.setStatut(false);
        return borneRepository.save(existingBorne);
    }

    // public static List<Ligne> getAllTroncon() {

    // List<Ligne> lignes = new ArrayList<>();

    // ligneRepository.findByStatutJPQL(statut).forEach(lignes::add);

    // return lignes;

    // }

}
