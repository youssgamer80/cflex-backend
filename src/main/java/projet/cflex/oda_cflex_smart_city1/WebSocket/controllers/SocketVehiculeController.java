package projet.cflex.oda_cflex_smart_city1.WebSocket.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projet.cflex.oda_cflex_smart_city1.WebSocket.sockets.SocketVehicule;

import javax.websocket.EncodeException;
import java.io.IOException;


@Controller
@RequestMapping(value = "/")
public class SocketVehiculeController {
    @RequestMapping(value = "/broadcastVehicule")
    public ResponseEntity<String> testVehiculeSocket(@RequestParam("message") String message) throws IOException, EncodeException {
        SocketVehicule.broadcastVehicule(message);
        String successMessage = String.format("Opération effectuée! " +
                "Data broadcast to %s listeners", SocketVehicule.listeners.size());
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }
}