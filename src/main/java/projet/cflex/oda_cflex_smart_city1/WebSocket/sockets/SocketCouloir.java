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
import projet.cflex.oda_cflex_smart_city1.MongoDB.controller.CouloirController;
import projet.cflex.oda_cflex_smart_city1.MongoDB.model.Couloir;
import projet.cflex.oda_cflex_smart_city1.MongoDB.repository.CouloirRepository;
import projet.cflex.oda_cflex_smart_city1.WebSocket.utils.MessageDecoder;
import projet.cflex.oda_cflex_smart_city1.WebSocket.utils.MessageEncoder;

@Slf4j
@Component
@ServerEndpoint(value = "/webSocket2", encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class SocketCouloir {
    private Session session;

    @Autowired
    static
    CouloirRepository couloirRepository;

    public static Set<SocketCouloir> listeners = new CopyOnWriteArraySet<>();


    @OnOpen
    public void onOpen(Session session) throws InterruptedException {
        this.session = session;
        listeners.add(this);
        log.info(String.format("Un couloir connecté: %s", listeners.size()));
    }


    @OnMessage //Allows the client to send message to the socket.
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
        //Error
    }

    

    public static void broadcast(String message) {
        
        Couloir couloir;
        CouloirController couloirController = new CouloirController();
        JSONObject value = new JSONObject(message) ;
        String idcouloir = value.getString("idcouloir");
        Integer nb_place = value.getInt("nb_place");
        Integer nb_person = value.getInt("nb_person");

        couloir = new Couloir(idcouloir,nb_place,nb_person);
        for (SocketCouloir listener : listeners) {
            listener.sendMessage(message);
            couloirController.createCouloir(new Couloir(idcouloir,nb_place,nb_person));
        }
        saveCouloirinMongo(new Couloir(idcouloir,nb_place,nb_person));

    }


    private void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.error("Caught exception while sending message to Session Id: " + this.session.getId(), e.getMessage(), e);
        }
    }

    public static ResponseEntity<Couloir> saveCouloirinMongo(@RequestBody Couloir couloir) {
        
        if(couloir.getIdCouloir()==null) {
            Couloir _couloir = couloirRepository.save(couloir);
            return new ResponseEntity<>(_couloir, HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}