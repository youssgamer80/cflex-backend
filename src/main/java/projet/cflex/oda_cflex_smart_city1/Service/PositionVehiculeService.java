package projet.cflex.oda_cflex_smart_city1.Service;

import projet.cflex.oda_cflex_smart_city1.Model.PositionVehicule;
import projet.cflex.oda_cflex_smart_city1.Model.Proprietaire;
import projet.cflex.oda_cflex_smart_city1.exception.PositionVehiculeException;

import javax.validation.Constraint;
import javax.validation.ConstraintViolationException;
import java.util.Collection;

public interface PositionVehiculeService {
    PositionVehicule create(PositionVehicule positionVehicule);
    Collection<PositionVehicule> list(boolean isDeleted);
    PositionVehicule get(Long id);
    public void createTracker(PositionVehicule positionVehicule) throws ConstraintViolationException, PositionVehiculeException;
}
