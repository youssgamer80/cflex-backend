package projet.cflex.oda_cflex_smart_city1.MongoDB.controller;

import projet.cflex.oda_cflex_smart_city1.MongoDB.model.Tracker;
import projet.cflex.oda_cflex_smart_city1.MongoDB.repository.TrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TrackerController {

  @Autowired
  TrackerRepository trackerRepository;

  @GetMapping("/gettrackers")
  public ResponseEntity<List<Tracker>> getAllTrackers(@RequestParam(required = false) String typetransport) {
    try {
      List<Tracker> trackers = new ArrayList<Tracker>();

      if (typetransport == null)
        trackerRepository.findAll().forEach(trackers::add);
      else
        trackerRepository.findByTypetransport(typetransport).forEach(trackers::add);

      if (trackers.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(trackers, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/settracker/{id}")
  public ResponseEntity<Tracker> getTrackerById(@PathVariable("id") String id) {
    Optional<Tracker> trackerData = trackerRepository.findById(id);

    if (trackerData.isPresent()) {
      return new ResponseEntity<>(trackerData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/settrackers")
  public ResponseEntity<Tracker> createTracker(@RequestBody Tracker tracker) {
    try {
      Tracker _tracker = trackerRepository.save(new Tracker(tracker.getId(),tracker.getImmatriculation(), tracker.getIdtracker(),tracker.getLattitude(), tracker.getLongitude(),tracker.getTypetransport()));
      return new ResponseEntity<>(_tracker, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/updatetrackers/{id}")
  public ResponseEntity<Tracker> updateTracker(@PathVariable("id") String id, @RequestBody Tracker tracker) {
    Optional<Tracker> tutorialData = trackerRepository.findById(id);

    if (tutorialData.isPresent()) {
      Tracker _tracker = tutorialData.get();
      _tracker.setLattitude(tracker.getLattitude());
      _tracker.setLongitude(tracker.getLongitude());
      _tracker.setTypetransport(tracker.getTypetransport());
      return new ResponseEntity<>(trackerRepository.save(_tracker), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/trackers/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
    try {
      trackerRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/trackers")
  public ResponseEntity<HttpStatus> deleteAllTrackers() {
    try {
      trackerRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /*@GetMapping("/tutorials/published")
  public ResponseEntity<List<Tutorial>> findByPublished() {
    try {
      List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

      if (tutorials.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }*/

}
