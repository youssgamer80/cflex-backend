package projet.cflex.oda_cflex_smart_city1.MongoDB.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import projet.cflex.oda_cflex_smart_city1.MongoDB.model.Couloir;
import projet.cflex.oda_cflex_smart_city1.MongoDB.model.ResponseCouloir;
import projet.cflex.oda_cflex_smart_city1.MongoDB.repository.CouloirRepository;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CouloirController {

  @Autowired
  CouloirRepository couloirRepository;

  @GetMapping("/getcouloirs")
  public ResponseEntity<List<Couloir>> getAllCouloirs() {
    try {
      List<Couloir> couloirs = new ArrayList<Couloir>();
      return new ResponseEntity<>(couloirs, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/setcouloir/{id}")
  public ResponseEntity<Couloir> getCouloirById(@PathVariable("id") String id) {
    Optional<Couloir> couloirData = couloirRepository.findById(id);

    if (couloirData.isPresent()) {
      return new ResponseEntity<>(couloirData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  Gson gson = new Gson();
  
  @PostMapping("/setcouloirs")
  public void getAffluence(String url) throws IOException {
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder().url("https://api.thingspeak.com/channels/1786759/feeds.json?api_key=FBINCPKCBHKLG9MG&results=2").build();
    try (Response response = client.newCall(request).execute()) {
     final String data = response.body().string();
     final ResponseCouloir  res = gson.fromJson(data,ResponseCouloir.class);
      Integer nb_person = Integer.parseInt(res.getFeeds().get(1).getField1());
      Integer nb_place =  Integer.parseInt(res.getFeeds().get(1).getField2());
      String id_couloir = res.getFeeds().get(1).getField3(); 
      System.out.println("nombre de personne:"+nb_person);
      System.out.println("nombre de personne:"+nb_place);
      System.out.println("id_couloir:"+id_couloir);
    }
   }
  public ResponseEntity<Couloir> createCouloir(@RequestBody Couloir couloir) {
    try {
      Couloir _couloir = couloirRepository.save(couloir);
      return new ResponseEntity<>(_couloir, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/updatecouloirs/{id}")
  public ResponseEntity<Couloir> updateCouloir(@PathVariable("id") String id, @RequestBody Couloir couloir) {
    Optional<Couloir> tutorialData = couloirRepository.findById(id);

    if (tutorialData.isPresent()) {
      Couloir _couloir = tutorialData.get();
      _couloir.setNbPerson(couloir.getNbPerson());
      _couloir.setNbPlace(couloir.getNbPlace());
      return new ResponseEntity<>(couloirRepository.save(_couloir), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/couloirs/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
    try {
      couloirRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/couloirs")
  public ResponseEntity<HttpStatus> deleteAllCouloirs() {
    try {
      couloirRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}


           
