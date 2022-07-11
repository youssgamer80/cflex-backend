package projet.cflex.oda_cflex_smart_city1.WebSocket.sockets;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import projet.cflex.oda_cflex_smart_city1.MongoDB.controller.TrackerController;
import projet.cflex.oda_cflex_smart_city1.MongoDB.model.Tracker;
import projet.cflex.oda_cflex_smart_city1.MongoDB.repository.TrackerRepository;
import projet.cflex.oda_cflex_smart_city1.WebSocket.utils.MessageDecoder;
import projet.cflex.oda_cflex_smart_city1.WebSocket.utils.MessageEncoder;

@Slf4j
@Component
@ServerEndpoint(value = "/webSocket", encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class SocketTracker {
    private Session session;

    @Autowired
    static TrackerRepository trackerRepository;

    public static Set<SocketTracker> listeners = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) throws InterruptedException {
        this.session = session;
        listeners.add(this);
        log.info(String.format("Un tracker connecté: %s", listeners.size()));
    }

    @OnMessage // Allows the client to send message to the socket.
    public void onMessage(String message) {
        broadcast(message);
    }

    @OnClose
    public void onClose(Session session) {
        listeners.remove(this);
        log.info(String.format("Déconnecté: %s", listeners.size()));
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Error
    }

    public static void broadcast(String message) {
        Vehicule vehicule;
        TrackerController trackerController = new TrackerController();
        JSONObject value = new JSONObject(message);
        String idtracker = value.getString("idtracker");
        String immatriculation = value.getString("immatriculation");
        String latitude = value.getString("latitude");
        String longitude = value.getString("longitude");
        String typetransport = value.getString("typetransport");
        /*
         * System.out.println(idtracker);
         * System.out.println(immatriculation);
         * System.out.println(latitude);
         * System.out.println(longitude);
         * System.out.println(typetransport);
         */
        for (SocketTracker listener : listeners) {
            listener.sendMessage(message);
            trackerController
                    .createTracker(new Tracker(idtracker, immatriculation, latitude, longitude, typetransport));
        }
        saveTrackerinMongo(new Tracker(idtracker, immatriculation, latitude, longitude, typetransport));

    }

    private void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.error("Caught exception while sending message to Session Id: " + this.session.getId(), e.getMessage(),
                    e);
        }
    }

    public static ResponseEntity<Tracker> saveTrackerinMongo(@RequestBody Tracker tracker) {

        if (tracker.getIdtracker() == null) {
            Tracker _tracker = trackerRepository.save(tracker);
            return new ResponseEntity<>(_tracker, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}