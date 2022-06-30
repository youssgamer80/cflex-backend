package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Controller.TronconTypeTransportObjet;
import projet.cflex.oda_cflex_smart_city1.Model.Troncon;
import projet.cflex.oda_cflex_smart_city1.Model.TronconTypeTransport;
import projet.cflex.oda_cflex_smart_city1.Model.TypeTransport;
import projet.cflex.oda_cflex_smart_city1.Repository.PointArretRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.TronconRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.TronconTypeTransportRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.TypeTransportRepository;

@Service
public class TronconTypeTransportService {
    private Boolean statut=true;
    @Autowired
    private  TronconRepository tronconRepo;
    @Autowired
    private  TypeTransportRepository typetransportRepo;
    private  TronconTypeTransportRepository repository;


    // @Autowired
    // private  TronconRepository tronconRepo;
    // @Autowired
    // private  TypeTransportRepository typetransportRepo;
    // @Autowired
    // private  TronconTypeTransportRepository repository;



    public List<TronconTypeTransport> ListByTroncon(Integer idTroncon){

        List<TronconTypeTransport> result = new ArrayList<>();
        repository.findByIdTronconFkNative(idTroncon).forEach(result::add);
        return result;

    }

    public List<TronconTypeTransport> Liste(){

        List<TronconTypeTransport> resultat = new ArrayList<>();
        repository.findByStatutJPQL(statut).forEach(resultat::add);

        return resultat;
    }



    public TronconTypeTransport add(TronconTypeTransportObjet troncontypetransportObjet){

        // System.out.println(troncontypetransportObjet.idTronconFk);
        TypeTransport typetransport = typetransportRepo.findTypeTransport(troncontypetransportObjet.idTypeTransportFk);
        Troncon troncon = tronconRepo.findTroncon(troncontypetransportObjet.idTronconFk);

        TronconTypeTransport troncontypetransport= new TronconTypeTransport();
        troncontypetransport.setIdTronconFk(troncon);
        troncontypetransport.setIdTypeTransportFk(typetransport);
        troncontypetransport.setPrix(troncontypetransportObjet.prix);
        troncontypetransport.setStatut(true);

        System.out.println(troncontypetransportObjet.idTronconFk);

        //System.out.println(troncon);

        return repository.save(troncontypetransport);

    }




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
