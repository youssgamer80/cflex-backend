package projet.cflex.oda_cflex_smart_city1.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Stationner;

import java.util.Collection;

public interface StationnerService {
    Collection<Stationner> list(boolean isDeleted);
}
