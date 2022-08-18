package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import projet.cflex.oda_cflex_smart_city1.payload.request.SignUpProprietaire;
import projet.cflex.oda_cflex_smart_city1.Repository.ProprietaireRepository;

@Service
@Transactional
@Slf4j
public class ProprietaireService {

    @Autowired
    public ProprietaireRepository proprietaireRepository;
    private Boolean statut=true;
    public SignUpProprietaire proprietaire;
    
    public SignUpProprietaire addProprio(SignUpProprietaire proprietaire) {
    log.info("Enregistrement d'un nouveau propriétaire: {}","Nom:"+" "+proprietaire.getNom()+"/"+
            "Prénoms:"+" "+proprietaire.getPrenom());
    
    return proprietaireRepository.save(proprietaire);
    }
}