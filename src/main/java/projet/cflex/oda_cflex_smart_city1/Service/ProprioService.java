package projet.cflex.oda_cflex_smart_city1.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Proprietaire;

import java.util.Collection;

public interface ProprioService {

    Proprietaire create(Proprietaire proprietaire);
    Collection <Proprietaire> list(boolean isDeleted);
    Proprietaire get(Integer id);
    Boolean delete(Integer id);


}
