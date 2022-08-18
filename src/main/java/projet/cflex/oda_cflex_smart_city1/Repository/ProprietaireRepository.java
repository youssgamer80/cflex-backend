package projet.cflex.oda_cflex_smart_city1.Repository;

import projet.cflex.oda_cflex_smart_city1.Model.Proprietaire;
import projet.cflex.oda_cflex_smart_city1.payload.request.SignUpProprietaire;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, Integer> {

    SignUpProprietaire save(SignUpProprietaire proprietaire);
}