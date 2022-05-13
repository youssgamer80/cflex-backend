package projet.cflex.oda_cflex_smart_city1.Service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.TypeTransport;
import projet.cflex.oda_cflex_smart_city1.Repository.TypeTransportRepository;


@Service
public class TypeTransportService {
    
    @Autowired
    public TypeTransportRepository typeTransportRepository;
    private Boolean statut=true;

    public List<TypeTransport> getAllTypeTransports() {
        
        List<TypeTransport> typeTransports = new ArrayList<>();

        typeTransportRepository.findByStatutJPQL(statut).forEach(typeTransports::add);

        return typeTransports;
    }
    
    public TypeTransport addTypeTransport(TypeTransport typeTransports) {

        return typeTransportRepository.save(typeTransports);
    }

    public TypeTransport getTypeTransport(int id) {

        return this.typeTransportRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Type Transport not found with id :" + id));
    }

    public TypeTransport updateTypeTransport(Integer id, TypeTransport typeTransport) {

        TypeTransport existingTypeTransport = this.typeTransportRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Type Transport not found with id :" + id));
        if(typeTransport.getLibelleTypeTransport()!=null){
            existingTypeTransport.setLibelleTypeTransport(typeTransport.getLibelleTypeTransport());
        }

		

       if(typeTransport.getStatut()!=null){
        existingTypeTransport.setStatut(typeTransport.getStatut());
   }

		return typeTransportRepository.save(existingTypeTransport);
    }

    public TypeTransport deleteTypeTransport(Integer id, TypeTransport typeTransport) {

        TypeTransport existingTypeTransport = this.typeTransportRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Type transport not found with id :" + id));
            existingTypeTransport.setStatut(typeTransport.getStatut());
		 return typeTransportRepository.save(existingTypeTransport);
    }
}
