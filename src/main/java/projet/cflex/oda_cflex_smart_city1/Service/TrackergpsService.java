package projet.cflex.oda_cflex_smart_city1.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Trackergps;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public interface TrackergpsService {
    Trackergps create(Trackergps trackergps);
    Collection<Trackergps> list(boolean isDeleted);
    Trackergps get(Integer id);
    // Trackergps getLibelle(String libelle);
    Boolean delete(Integer id);
    Trackergps majTrackergps(Integer id, Trackergps borne) ;
}
