package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Troncon;
import projet.cflex.oda_cflex_smart_city1.Repository.TronconRepository;

@Service
public class TronconService {
    private Boolean statut=true;

    @Autowired
    private final TronconRepository tronconRepo;
    @Autowired
    public TronconService(TronconRepository tronconRepo) {
        this.tronconRepo = tronconRepo;
    }

    public List<Troncon> Liste(){

        List<Troncon> troncons = new ArrayList<>();
        tronconRepo.findByStatutJPQL(statut).forEach(troncons::add);

        return troncons;
    }

    public Optional<Troncon> TronconById(Integer id){
        return tronconRepo.findById(id);

    }

    public List<Troncon> TronconByNom(String nom){
        List<Troncon> troncons = new ArrayList<>();
        tronconRepo.findByNom(nom).forEach(troncons::add);

        return troncons;
    }

    public Troncon deleteTroncon(Integer id){
        Troncon realTroncon = this.tronconRepo.findById(id).orElseThrow(() -> new RuntimeException("Troncon" + id + "nexiste pas"));
        realTroncon.setStatut(false);
        return tronconRepo.save(realTroncon);
    }

    public Troncon AddTroncon(Troncon troncon) {

        return tronconRepo.save(troncon);
    }

    

    public Troncon updateTroncon(Integer id, Troncon troncon) {

        Troncon existingTroncon = this.tronconRepo.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Troncon not found with id :" + id));

        if(troncon.getNom()!=null){
            existingTroncon.setNom(troncon.getNom());
        }

        if(troncon.getIdPointArretAFk()!=null){
            existingTroncon.setIdPointArretAFk(troncon.getIdPointArretAFk());
        }

        if(troncon.getIdPointArretBFk()!=null){
            existingTroncon.setIdPointArretBFk(troncon.getIdPointArretBFk());
        }

        if(troncon.getDistance()!=null){
            existingTroncon.setDistance(troncon.getDistance());
        }

        if(troncon.getDuree()!=null){
            existingTroncon.setDuree(troncon.getDuree());
        }

        if(troncon.getTarif()!=null){
            existingTroncon.setTarif(troncon.getTarif());
        }

        if(troncon.getStatut()!=null){
            existingTroncon.setStatut(troncon.getStatut());
        }

        if(troncon.getIdLigneFk()!=null){
            existingTroncon.setIdLigneFk(troncon.getIdLigneFk());
        }
       
        if(troncon.getRang()!=null){
            existingTroncon.setRang(troncon.getRang());
        }

		return tronconRepo.save(existingTroncon);
 }



    
}
