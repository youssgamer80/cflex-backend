package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Usager;
import projet.cflex.oda_cflex_smart_city1.Repository.UsagerRepository;

@Service
public class UsagerService {

    @Autowired
    public UsagerRepository usagerRepository;
    private Boolean statut=true;
    public Usager usager;


    public List<Usager> getAllUsagers() {
        
        List<Usager> usagers = new ArrayList<>();

        usagerRepository.findByStatutJPQL(statut).forEach(usagers::add);

        return usagers;
    }
    
    public Usager addUsager(Usager usager) {
        usager.setStatut(true);
        return usagerRepository.save(usager);
    }

    public Usager getUsager(int id) {

        return this.usagerRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Usager not found with id :" + id));
    }

    public Usager updateUsager(Integer id, Usager usager) {

        Usager existingUsager = this.usagerRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Usager not found with id :" + id));
        if(usager.getNom()!=null){
             existingUsager.setNom(usager.getNom());
        }

		if(usager.getPrenom()!=null){
             existingUsager.setPrenom(usager.getPrenom());
       }

       if(usager.getTelephone()!=null){
        existingUsager.setTelephone(usager.getTelephone());
       }

       if(usager.getStatut()!=null){
        existingUsager.setStatut(usager.getStatut());
   }

		return usagerRepository.save(existingUsager);
    }

    public Usager deleteUsager(Integer id, Usager usager) {

        Usager existingUsager = this.usagerRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Usager not found with id :" + id));
		 existingUsager.setStatut(usager.getStatut());
		 return usagerRepository.save(existingUsager);
    }
    

}