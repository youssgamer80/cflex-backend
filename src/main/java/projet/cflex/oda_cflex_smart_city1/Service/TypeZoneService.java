package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import projet.cflex.oda_cflex_smart_city1.Model.TypeZone;
import projet.cflex.oda_cflex_smart_city1.Model.Zone;
import projet.cflex.oda_cflex_smart_city1.Repository.TypeZoneRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.ZoneRepository;

@Service
public class TypeZoneService {
    @Autowired
    private TypeZoneRepository typeZoneRepository;
    @Autowired
    private ZoneRepository zoneRepository;
    public Zone zone;

    private Boolean statut = true;

    public List<TypeZone> getAllTypeZones() {

    List<TypeZone> typeZones = new ArrayList<>();

    typeZoneRepository.findByStatutJPQL(statut).forEach(typeZones::add);

    return typeZones;
    }

    public TypeZone addTypeZone(TypeZone typeZone) {

        return typeZoneRepository.save(typeZone);
    }

    public TypeZone getTypeZone(int id) {

        return this.typeZoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Type Zone not found with id :" + id));
    }

    // public TypeZone getlibelleTypeZone(String libelleTypeZone) {
    // return typeZoneRepository.findBylibelleTypeZone(libelleTypeZone);
    // }

    public TypeZone updateTypeZone(Integer id, TypeZone typeZone) {

        TypeZone existingTypeZone = this.typeZoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Type Zone not found with id :" + id));

        if (typeZone.getLibelle() != null) {
            existingTypeZone.setLibelle(typeZone.getLibelle());
        }

        if (typeZone.getStatut() != null) {
            existingTypeZone.setStatut(true);
        }

        return typeZoneRepository.save(existingTypeZone);
    }

    public TypeZone deleteTypeZone(Integer id) {
        TypeZone existingTypeZone = this.typeZoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Type Zone not found with id :" + id));
        existingTypeZone.setStatut(false);
        zoneRepository.findByIdTypeZoneFkNative(id);
        return typeZoneRepository.save(existingTypeZone);
    }

    // Service Put

}
