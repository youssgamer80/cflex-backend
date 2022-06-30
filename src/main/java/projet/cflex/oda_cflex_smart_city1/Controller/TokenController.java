package projet.cflex.oda_cflex_smart_city1.Controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projet.cflex.oda_cflex_smart_city1.Implementation.TokenServiceImpl;
import projet.cflex.oda_cflex_smart_city1.Model.Proprietaire;
import projet.cflex.oda_cflex_smart_city1.Model.Token;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import projet.cflex.oda_cflex_smart_city1.Repository.ProprietaireRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.TokenRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.VehiculeRepository;

import static projet.cflex.oda_cflex_smart_city1.Controller.ProprietaireController.random;

@RequestMapping(value = "/token")
@RestController
public class TokenController {
    @Autowired
    TokenServiceImpl tokenService;
    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    VehiculeRepository vehiculeRepository ;
    @Autowired
    ProprietaireRepository proprietaireRepository ;
    @PostMapping("/generatebyproprio")
    public ResponseEntity<Token>  generateToken(@RequestBody Integer vehicule, @RequestBody Integer proprio) {

        Vehicule vehicule1 = vehiculeRepository.getById(vehicule);
        Proprietaire proprietaire1 = proprietaireRepository.getById(proprio);

        Token token = new Token();
        token.setVehicule(vehicule1);
        token.setProprietaire(proprietaire1);
        long longToken = Math.abs( random.nextLong() );
        String random = Long.toString( longToken, 10 );
        String _token = "test"+random;
        token.setToken(_token);

        return new ResponseEntity<>(tokenRepository.save(token), HttpStatus.CREATED);
    }

}
