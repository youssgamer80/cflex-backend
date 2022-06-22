package projet.cflex.oda_cflex_smart_city1.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projet.cflex.oda_cflex_smart_city1.Implementation.UtilisateurServiceImpl;
import projet.cflex.oda_cflex_smart_city1.Implementation.VehiculeServiceImpl;
import projet.cflex.oda_cflex_smart_city1.Model.Proprietaire;
import projet.cflex.oda_cflex_smart_city1.Model.Utilisateur;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import projet.cflex.oda_cflex_smart_city1.Repository.UtilisateurRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.VehiculeRepository;
import projet.cflex.oda_cflex_smart_city1.Response.Response;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("utilisateur")
@RequiredArgsConstructor
public class UtilisateurController {
    @Autowired
    private final UtilisateurServiceImpl utilisateurService;
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @GetMapping("/list")
    public ResponseEntity<Response> getUtilisateur(){
        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("utilisateur", utilisateurService.list(true)))
                .message("Liste des utilisateurs")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }


    @PostMapping("/saveutilisateur")
    public ResponseEntity<Response> saveUtilisateur(@RequestBody @Validated Utilisateur utilisateur){
        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("utilisateur", utilisateurService.create(utilisateur)))
                .message("Utilisateur enregistré avec succès")
                .status(CREATED)
                .statusCode(CREATED.value())
                .build()
        );
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getUtilisateur(@PathVariable("id") Integer id){
        return ResponseEntity.ok(Response.builder().timeStamp(now()).
                data(Map.of("utilisateur", utilisateurService.get(id)))
                .message("Utilisateur trouvé")
                .status(OK)
                .statusCode(OK.value())
                .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteUtilisateur(@PathVariable("id") Integer id){
        boolean exists = utilisateurRepository.existsById(id);
        if(!exists){throw new IllegalStateException("L'utilisateur avec le numero "+id+" n'existe pas");}
        else {
            return ResponseEntity.ok(Response.builder().timeStamp(now()).
                    data(Map.of("delete", utilisateurService.delete(id)))
                    .message("L'utilisateur avec le numero "+id+" a été supprimé avec succès")
                    .status(OK)
                    .statusCode(OK.value())
                    .build()
            );}
    }

    @PutMapping(value = "/updateutilisateur/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable("id") Integer id, @RequestBody Utilisateur utilisateur) {

        Optional<Utilisateur> existingutilisateur = Optional.ofNullable(this.utilisateurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cet utilisateur n'existe pas :" + id)));
        if (existingutilisateur.isPresent()) {
            Utilisateur _utilisateur = existingutilisateur.get();
            _utilisateur.setId(_utilisateur.getId());
            _utilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
            _utilisateur.setMotDePasse(utilisateur.getMotDePasse());
            _utilisateur.setRole(utilisateur.getRole());
            _utilisateur.setStatut(utilisateur.getStatut());

            return new ResponseEntity<>(utilisateurRepository.save(_utilisateur), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
