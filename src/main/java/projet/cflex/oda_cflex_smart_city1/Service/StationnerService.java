package projet.cflex.oda_cflex_smart_city1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projet.cflex.oda_cflex_smart_city1.Model.Stationner;
import projet.cflex.oda_cflex_smart_city1.Repository.StationnerRepository;

import java.util.Optional;

@Service
public class StationnerService {
    @Autowired
    StationnerRepository stationnerRepository;
    public Optional<Stationner> AllStationnement(Stationner stationner){
        return  stationnerRepository.findById(stationner.getIdVehiculeFk().getId());
    }

}


