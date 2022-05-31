package projet.cflex.oda_cflex_smart_city1.Service;

import projet.cflex.oda_cflex_smart_city1.Model.PositionVehicule;

public interface PositionVehiculeService {
    PositionVehicule create(PositionVehicule positionVehicule);

   void run(PositionVehicule positionVehicule);
}
