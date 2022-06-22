package projet.cflex.oda_cflex_smart_city1.Service;

import projet.cflex.oda_cflex_smart_city1.Model.Utilisateur;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;

import java.util.Collection;

public interface UtilisateurService {
    Utilisateur create(Utilisateur utilisateur);
    Collection<Utilisateur> list(boolean isDeleted);
    Utilisateur get(Integer id);
    Boolean delete(Integer id);
}
