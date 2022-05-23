package projet.cflex.oda_cflex_smart_city1.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Borne;

import java.util.Collection;

public interface BorneService {
    Borne create(Borne borne);
    Collection<Borne> list(boolean isDeleted);
    Borne get(Integer id);
    Boolean delete(Integer id);
    Borne majBorne(Integer id, Borne borne) ;
}
