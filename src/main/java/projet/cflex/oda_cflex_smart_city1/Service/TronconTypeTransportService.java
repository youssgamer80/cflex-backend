package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.TronconTypeTransport;
import projet.cflex.oda_cflex_smart_city1.Repository.TronconTypeTransportRepository;

@Service
public class TronconTypeTransportService {
    private Boolean statut=true;
    @Autowired
    private final TronconTypeTransportRepository repository;

    public TronconTypeTransportService(TronconTypeTransportRepository repository) {
        this.repository = repository;
    }

    public List<TronconTypeTransport> List(Integer idTroncon){

        List<TronconTypeTransport> result = new ArrayList<>();
        repository.findByIdTronconFkNative(idTroncon).forEach(result::add);
        return result;

    }

    public List<TronconTypeTransport> Liste(){

        List<TronconTypeTransport> resultat = new ArrayList<>();
        repository.findByStatutJPQL(statut).forEach(resultat::add);

        return resultat;
    }
    // public TronconTypeTransport add(TronconTypeTransport troncontypetransport) {
    //     return repository.save(troncontypetransport);
    // }

    public TronconTypeTransport updateTronconTypeTransport(Integer id, TronconTypeTransport newTTT) {

        TronconTypeTransport existing = this.repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Troncon not found with id :" + id));

        if(newTTT.getIdTronconFk()!=null){
            newTTT.setIdTronconFk(existing.getIdTronconFk());

        }

        if(newTTT.getIdTypeTransportFk()!=null){
            existing.setIdTypeTransportFk(newTTT.getIdTypeTransportFk());
        }

        if(newTTT.getPrix()!=null){
            existing.setPrix(newTTT.getPrix());
        }

        if(newTTT.getStatut()!=null){
            existing.setStatut(newTTT.getStatut());
        }
       
		return repository.save(existing);
 }



    public TronconTypeTransport delete(Integer id){
        TronconTypeTransport real = this.repository.findById(id).orElseThrow(() -> new RuntimeException("Le troncon_type_transport" + id + "nexiste pas"));
        real.setStatut(false);
        return repository.save(real);
    }

    
}
