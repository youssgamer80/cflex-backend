package projet.cflex.oda_cflex_smart_city1.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;

import java.util.Collection;
import java.util.Optional;

public interface VehiculeService {
    Vehicule create(Vehicule vehicule);
    Collection<Vehicule> list(boolean isDeleted);
    Vehicule get(Integer id);
    Boolean delete(Integer id);
    Vehicule majVehicule(Integer id, Vehicule vehicule) ;
   //  Optional<Vehicule> listvehiculeproprio(boolean isDeleted, Vehicule vehicule);

}
