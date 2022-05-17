package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import projet.cflex.oda_cflex_smart_city1.Model.Trackergps;
import projet.cflex.oda_cflex_smart_city1.Repository.TrackergpsRepository;


@Service
public class TrackergpsService {
    


    @Autowired
    private TrackergpsRepository trackergpsRepository;
    private boolean statut= true;
    
    public List<Trackergps> getAllTrackergps(){

        List<Trackergps> trackergps = new ArrayList<>();

        this.trackergpsRepository.findByStatutJPQL(statut).forEach(trackergps::add);

        return trackergps;

    }

    public Trackergps getTrackergps(int id){

        return trackergpsRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Borne not found with id :" + id));
    }


    public Trackergps addTrackergps(Trackergps trackergps){
        return trackergpsRepository.save(trackergps);
    }


    public Trackergps updateTrackergps(Trackergps trackergps,Integer id) {

        Trackergps existingTrackergps= this.trackergpsRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Trackergps not found with id :" + id));
        if(trackergps.getLibelle()!=null){
            existingTrackergps.setLibelle(trackergps.getLibelle());
        }

		if(trackergps.getIdVehiculeFk()!=null){
            existingTrackergps.setIdVehiculeFk(trackergps.getIdVehiculeFk());
       }

       if(trackergps.getStatut()!=null){
        existingTrackergps.setStatut(trackergps.getStatut());
       }

		return trackergpsRepository.save(existingTrackergps);
    }


    public Trackergps deleteTrackergps(Integer id, Trackergps trackergps) {

        Trackergps existingBorne = this.trackergpsRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Borne not found with id :" + id));
		 existingBorne.setStatut(trackergps.getStatut());
		 return trackergpsRepository.save(existingBorne);
    }
}
