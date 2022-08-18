package projet.cflex.oda_cflex_smart_city1.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import projet.cflex.oda_cflex_smart_city1.Implementation.ProprietaireServiceImpl;
import projet.cflex.oda_cflex_smart_city1.Model.Proprietaire;
import projet.cflex.oda_cflex_smart_city1.Repository.ProprietaireRepository;
import projet.cflex.oda_cflex_smart_city1.Response.Response;

import java.security.SecureRandom;
import java.util.Map;
import java.util.Optional;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("api/proprietaire")
@RequiredArgsConstructor
public class ProprietaireController {
    protected static SecureRandom random = new SecureRandom();
    @Autowired
    private final ProprietaireServiceImpl proprietaireService;
    @Autowired
    ProprietaireRepository proprietaireRepository;

    @GetMapping("/list")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Response> getProprietaire() {
        return ResponseEntity
                .ok(Response.builder().timeStamp(now()).data(Map.of("proprietaire", proprietaireService.list(true)))
                        .message("Proprietaire recupéré")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Response> saveProprietaire(@RequestBody @Validated Proprietaire proprietaire) {
        return ResponseEntity.ok(Response.builder().timeStamp(now())
                .data(Map.of("proprietaire", proprietaireService.create(proprietaire)))
                .message("Proprietaire enregistré avec succès")
                .status(CREATED)
                .statusCode(CREATED.value())
                .build());
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Response> getProprietaire(@PathVariable("id") Integer id) {
        return ResponseEntity
                .ok(Response.builder().timeStamp(now()).data(Map.of("proprietaire", proprietaireService.get(id)))
                        .message("Proprietaire retrouvé")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Response> deleteProprietaire(@PathVariable("id") Integer id) {
        boolean exists = proprietaireRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Le proprietaire avec le numero " + id + " n'existe pas");
        } else {
            return ResponseEntity
                    .ok(Response.builder().timeStamp(now()).data(Map.of("delete", proprietaireService.delete(id)))
                            .message("Le propriétaire avec le numero " + id + " a été supprimé avec succès")
                            .status(OK)
                            .statusCode(OK.value())
                            .build());
        }
    }

    @PutMapping(value = "/updateproprietaire/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('PROPRIETAIRE') or hasRole('ADMIN')")
    public ResponseEntity<Proprietaire> updateProprietaire(@PathVariable("id") Integer id,
            @RequestBody Proprietaire proprietaire) {

        Optional<Proprietaire> existingproprio = Optional.ofNullable(this.proprietaireRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ce proprietaire n'existe pas :" + id)));
        if (existingproprio.isPresent()) {
            Proprietaire _proprietaire = existingproprio.get();
            _proprietaire.setId(proprietaire.getId());
            _proprietaire.setNom(proprietaire.getNom());
            _proprietaire.setPrenom(proprietaire.getPrenom());
            _proprietaire.setTelephone(proprietaire.getTelephone());
            _proprietaire.setEmail(proprietaire.getEmail());
            _proprietaire.setStatut(proprietaire.getStatut());
            _proprietaire.setPermis(proprietaire.getPermis());
            _proprietaire.setDateNaissance(proprietaire.getDateNaissance());
            _proprietaire.setGenre(proprietaire.getGenre());
            _proprietaire.setLieuNaissance(proprietaire.getLieuNaissance());
            _proprietaire.setLieuResidence(proprietaire.getLieuResidence());
            _proprietaire.setPieceIdentite(proprietaire.getPieceIdentite());

            return new ResponseEntity<>(proprietaireRepository.save(_proprietaire), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
