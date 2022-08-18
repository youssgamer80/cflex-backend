/*
 * package projet.cflex.oda_cflex_smart_city1.Controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.gavaghan.geodesy.*;
 * import org.springframework.http.ResponseEntity;
 * import org.springframework.web.bind.annotation.*;
 * import projet.cflex.oda_cflex_smart_city1.Repository.PointArretRepository;
 * import
 * projet.cflex.oda_cflex_smart_city1.Repository.TrackerCouloirGetRepository;
 * import
 * projet.cflex.oda_cflex_smart_city1.Repository.TrackerCouloirRepository;
 * import projet.cflex.oda_cflex_smart_city1.exception.ResponseHandler;
 * 
 * import java.io.IOException;
 * import java.lang.reflect.Array;
 * import java.util.ArrayList;
 * import java.util.List;
 * import java.util.Map;
 * import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.http.ResponseEntity;
 * import org.springframework.web.bind.annotation.DeleteMapping;
 * import org.springframework.web.bind.annotation.GetMapping;
 * import org.springframework.web.bind.annotation.PathVariable;
 * import org.springframework.web.bind.annotation.PostMapping;
 * import org.springframework.web.bind.annotation.PutMapping;
 * import org.springframework.web.bind.annotation.RequestBody;
 * import org.springframework.web.bind.annotation.RequestMapping;
 * import org.springframework.web.bind.annotation.RestController;
 * 
 * import com.google.gson.Gson;
 * 
 * import okhttp3.OkHttpClient;
 * import okhttp3.Request;
 * import okhttp3.Response;
 * import projet.cflex.oda_cflex_smart_city1.Model.PointArret;
 * import projet.cflex.oda_cflex_smart_city1.Model.ResponseTracker;
 * import projet.cflex.oda_cflex_smart_city1.Model.TrackerCouloir;
 * import projet.cflex.oda_cflex_smart_city1.Model.TrackerCouloirGet;
 * import projet.cflex.oda_cflex_smart_city1.MongoDB.model.Couloir;
 * import projet.cflex.oda_cflex_smart_city1.MongoDB.model.ResponseCouloir;
 * import
 * projet.cflex.oda_cflex_smart_city1.MongoDB.repository.CouloirRepository;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * import java.util.Optional;
 * 
 * //@CrossOrigin(origins = "http://localhost:8081")
 * 
 * @RestController
 * 
 * @RequestMapping("/api/trackercouloir")
 * public class TrackerCouloirController {
 * 
 * @Autowired
 * TrackerCouloirRepository trackercouloirRepository;
 * 
 * @Autowired
 * TrackerCouloirGetRepository trackercouloirgetRepository;
 * 
 * @Autowired
 * public PointArretRepository pointarretRepository;
 * 
 * public double distance(double lat1, double lat2, double lon1, double lon2,
 * double el1, double el2) {
 * GeodeticCalculator geoCalc = new GeodeticCalculator();
 * Ellipsoid reference = Ellipsoid.WGS84;
 * GlobalPosition pointArret = new GlobalPosition(lat1, lon1, 0.0);
 * GlobalPosition tracker = new GlobalPosition(lat2, lon2, 0.0);
 * double distance = geoCalc.calculateGeodeticCurve(reference, tracker,
 * pointArret).getEllipsoidalDistance();
 * return distance;
 * }
 * 
 * @GetMapping(value = "/gettrackercouloir/{longitude}/{latitude}")
 * public List<TrackerCouloirGet> getTrackerCouloir(@PathVariable Double
 * longitude, @PathVariable Double latitude) {
 * double el1 = 0;
 * double el2 = 0;
 * ArrayList<TrackerCouloirGet> trackercouloirgetData =
 * trackercouloirgetRepository.findAll();
 * System.out.println(trackercouloirgetData.get(1));
 * for (int i = 0; i < trackercouloirgetData.size(); i++) {
 * TrackerCouloirGet track = trackercouloirgetData.get(i);
 * 
 * List<TrackerCouloirGet> trackercouloirResultats = new ArrayList<>();
 * List<TrackerCouloirGet> trackerCouloirs =
 * trackercouloirgetRepository.findAll();
 * trackerCouloirs.forEach(
 * tracker -> {
 * if (distance(latitude, tracker.getLatitude(), longitude,
 * tracker.getLongitude(), el1, el2) <= 3000) {
 * System.out
 * .println(distance(latitude, tracker.getLatitude(), longitude,
 * tracker.getLongitude(), el1, el2));
 * System.out.println(tracker.getImmatriculation() + " " +
 * tracker.gettypetransport());
 * trackercouloirResultats.add(tracker);
 * }
 * });
 * 
 * return trackercouloirResultats;
 * }
 * return null;
 * 
 * }
 * 
 * Gson gson = new Gson();
 * 
 * @PostMapping(value="/settrackercouloir/{longitude}/{latitude}")
 * 
 * public TrackerCouloirGet createTrackerCouloir(@PathVariable Double
 * longitude, @PathVariable Double latitude) throws IOException {
 * 
 * OkHttpClient client = new OkHttpClient();
 * Request request = new Request.Builder()
 * .url(
 * "https://api.thingspeak.com/channels/1786759/feeds.json?api_key=FBINCPKCBHKLG9MG&results=2"
 * ).build();
 * Response response = client.newCall(request).execute();
 * final String data = response.body().string();
 * final ResponseCouloir res = gson.fromJson(data, ResponseCouloir.class);
 * Integer nb_person = Integer.parseInt(res.getFeeds().get(1).getField1());
 * Integer nb_place = Integer.parseInt(res.getFeeds().get(1).getField2());
 * String id_couloir = res.getFeeds().get(1).getField3();
 * System.out.println("nombre de personne:" + nb_person);
 * System.out.println("nombre de place:" + nb_place);
 * System.out.println("id_couloir:" + id_couloir);
 * 
 * OkHttpClient nextclient = new OkHttpClient();
 * Request nextrequest = new Request.Builder()
 * .url(
 * "https://api.thingspeak.com/channels/1757494/feeds.json?api_key=EPV5WIRQ3UOYA1RE&results=2"
 * ).build();
 * Response nextresponse = nextclient.newCall(nextrequest).execute();
 * final String nextdata = nextresponse.body().string();
 * final ResponseTracker nextres = gson.fromJson(nextdata,
 * ResponseTracker.class);
 * String idtracker = nextres.getFeeds().get(1).getField1();
 * String immatriculation = nextres.getFeeds().get(1).getField2();
 * String TypeTransport = nextres.getFeeds().get(1).getField3();
 * Double lat = Double.parseDouble(nextres.getFeeds().get(1).getField4());
 * Double lon = Double.parseDouble(nextres.getFeeds().get(1).getField5());
 * 
 * System.out.println("idtracker:" + idtracker);
 * System.out.println("immatriculation:" + immatriculation);
 * System.out.println("latitude:" + latitude);
 * System.out.println("longitude:" + longitude);
 * System.out.println("typetransport:" + TypeTransport);
 * 
 * double el1 = 0;
 * double el2 = 0;
 * Integer nbVehiculeApproche = 1;
 * TrackerCouloir tc = new TrackerCouloir(id_couloir, nb_person, idtracker,
 * immatriculation, lat,
 * lon, TypeTransport,nbVehiculeApproche);
 * System.out.print(tc);
 * trackercouloirRepository.save(tc);
 * TrackerCouloirGet affluence;
 * ArrayList<TrackerCouloirGet> trackercouloirgetData =
 * trackercouloirgetRepository.findAll();
 * System.out.println(trackercouloirgetData.get(1));
 * List<TrackerCouloirGet> trackercouloirResultats = new ArrayList<>();
 * List<TrackerCouloirGet> trackerCouloirs =
 * trackercouloirgetRepository.findAll();
 * for (int i = 0; i < trackercouloirgetData.size(); i++) {
 * TrackerCouloirGet track = trackercouloirgetData.get(i);
 * 
 * trackerCouloirs.forEach(
 * tracker -> {
 * if (distance(latitude, tracker.getLatitude(), longitude,
 * tracker.getLongitude(), el1, el2) <=7000) {
 * System.out
 * .println(distance(latitude, tracker.getLatitude(), longitude,
 * tracker.getLongitude(), el1, el2));
 * System.out.println(tracker.getImmatriculation() + " " +
 * tracker.gettypetransport());
 * trackercouloirResultats.add(tracker);
 * }
 * });
 * 
 * affluence = trackercouloirResultats.get(trackercouloirResultats.size()-1);
 * return affluence;
 * 
 * }
 * 
 * return null;
 * 
 * }
 * }
 */