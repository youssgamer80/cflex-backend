package projet.cflex.oda_cflex_smart_city1.Service;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.internal.util.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Controller.TrackergpsObject;
import projet.cflex.oda_cflex_smart_city1.Model.Trackergps;
// import projet.cflex.oda_cflex_smart_city1.Model.TypeTransport;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import projet.cflex.oda_cflex_smart_city1.Repository.TrackergpsRepository;
// import projet.cflex.oda_cflex_smart_city1.Repository.TypeTransportRepository;
import projet.cflex.oda_cflex_smart_city1.Service.VehiculeService;

@Service
public class TrackergpsService {

    @Autowired
    public TrackergpsRepository trackergpsRepository;

    @Autowired
    private VehiculeService vehiculeService;

    private static Boolean statut = true;

    public List<Trackergps> getAllTrackergps() {

        List<Trackergps> trackergps = new ArrayList<>();

        trackergpsRepository.findByStatutJPQL(statut).forEach(trackergps::add);

        return trackergps;
    }

    public Trackergps addTrackergps(TrackergpsObject trackergpsObject) {

        Trackergps trackergps = new Trackergps();

        Vehicule vehicule = vehiculeService.get(trackergpsObject.idVehiculeFk);
        trackergps.setLibelle(trackergpsObject.libelle);
        trackergps.setIdVehiculeFk(vehicule);

        return trackergpsRepository.save(trackergps);
    }

    public Trackergps getTrackergps(String nomLigne) {
        System.out.print(nomLigne);
        return trackergpsRepository.findByLibelle(nomLigne);
    }

    public Trackergps getTrackergpsBydId(Integer id) {
        // System.out.print(id);

        Trackergps trackergps = trackergpsRepository.findTrackergps(id);

        return trackergps;
    }

    public Trackergps updateTrackergps(Integer id, TrackergpsObject trackergpsObject) {

        Trackergps existingTrackergps = trackergpsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Type Transport notfoundwith id :" + id));

        if (trackergpsObject.libelle != null) {
            existingTrackergps.setLibelle(trackergpsObject.libelle);
        }

        if (trackergpsObject.idVehiculeFk != null) {
            Vehicule vehicule = vehiculeService.get(trackergpsObject.idVehiculeFk);

            existingTrackergps.setIdVehiculeFk(vehicule);
        }

        existingTrackergps.setStatut(true);

        return trackergpsRepository.save(existingTrackergps);
    }

    public Trackergps deleteTrackergps(Integer id) {

        Trackergps existingTrackergps = trackergpsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trackergps not foundwith id:" + id));
        existingTrackergps.setStatut(false);
        return trackergpsRepository.save(existingTrackergps);
    }

    // public static List<Ligne> getAllTroncon() {

    // List<Ligne> lignes = new ArrayList<>();

    // ligneRepository.findByStatutJPQL(statut).forEach(lignes::add);

    // return lignes;

    // }

}
