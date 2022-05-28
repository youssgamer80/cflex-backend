package projet.cflex.oda_cflex_smart_city1.Controller;

import java.security.Timestamp;
import java.util.Map;
import java.util.Random;

import com.google.gson.Gson;

import org.apache.http.client.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.minidev.json.JSONObject;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import projet.cflex.oda_cflex_smart_city1.Model.Position;
import projet.cflex.oda_cflex_smart_city1.Model.Position;

@RestController // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RequestMapping("/api")
@Tag(name = "API Envoie de position utilisateurs", description = "Api service d'envoie de positions")
public class PostPosition{

    @PostMapping(value = "/position") // Map ONLY POST Requests

    public ResponseEntity<Object> postPosition() {


        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType, "{\n    \"collection\":\"positions\",\n    \"database\":\"bd_smart_city1\",\n    \"dataSource\":\"Cluster0\",\n    \"filter\": {\"_id\": 1}\n\n}");
        Request request = new Request.Builder()
            .url("https://data.mongodb-api.com/app/data-quxor/endpoint/data/beta/action/findOne")
            .method("POST", body)
            .addHeader("Content-Type", "application/json")
            .addHeader("Access-Control-Request-Headers", "*")
            .addHeader("api-key", "A6groFeJvrFtym4bB5q4JCpnENRU5gJBuB7lZNXqKdM0HPsqwueQnKOSsV7x6rxf")
                .build();
            
        try{        
            Response response = client.newCall(request).execute();
            
                    if (response.isSuccessful()) {
                        final String data = response.body().string();

                        return ResponseEntity.accepted().body(data);
                    }
            }catch(Exception e){
                
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

    return new ResponseEntity<Object>(HttpStatus.OK);
}

}
