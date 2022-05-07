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
    private Integer id;

    public List<Usager> getAllUsagers() {
        
        List<Usager> usagers = new ArrayList<>();

        usagerRepository.findAll().forEach(usagers::add);

        return usagers;
    }
    
    public Usager addUsager(Usager usager) {

        return usagerRepository.save(usager);
    }

    public Usager getUsager() {

        return this.usagerRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Usager not found with id :" + id));
    }

    public Usager updateUsager(Integer id, Usager usager) {

        Usager existingUsager = this.usagerRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Usager not found with id :" + id));
		 existingUsager.setNom(usager.getNom());
		 existingUsager.setPrenom(usager.getPrenom());
		 existingUsager.setTelephone(usager.getTelephone());
		 return usagerRepository.save(existingUsager);
    }

    public Usager deleteUsager(Integer id) {

        Usager existingUsager = this.usagerRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Usager not found with id :" + id));
		 existingUsager.setStatut(Usager.getStatut());
		 return usagerRepository.save(existingUsager);
    }

}
