package projet.cflex.oda_cflex_smart_city1.Controller;

import java.util.Map;
import java.util.Random;

import com.google.gson.Gson;

import org.apache.http.client.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import projet.cflex.oda_cflex_smart_city1.Model.MyPhone;
import projet.cflex.oda_cflex_smart_city1.Model.Myres;

@RestController // This means that this class is a Controller
@RequestMapping("/api")
@Tag(name = "API Envoie SmsOtp", description = "Api service d'envoie otp")
public class SmsOtpController {

    @PostMapping(value = "/sendotp") // Map ONLY POST Requests
            
        public ResponseEntity<Object> sendotp(String telephone, @RequestBody MyPhone myPhone) {
            
            String Telephone = myPhone.getTelephone();

            int min = 1;
		    int max = 1000;

		    Random random = new Random();

		    int value = random.nextInt(max + min) + min;

            System.out.println(value);
            
            int votp = 900009;

            var otp = votp + value ;

            votp = otp;

            Gson gson = new Gson();
    
                OkHttpClient httpClient = new OkHttpClient();
    
                FormBody formBody = new FormBody.Builder().add("grant_type", "client_credentials").build();
                Request request = new Request.Builder().url("https://api.orange.com/oauth/v3/token").post(formBody)
                        .addHeader("Authorization",
                                "Basic WVY0QVNUSDJVVFJDMEFXYU9qTXlPR1RNYlkzQnhPSmI6c2c4NURiMDJJVWtVOUdHVw==")
                        .build();
                try {
    
                    okhttp3.Response response = httpClient.newCall(request).execute();
                    if (response.isSuccessful()) {
                        
                        final String  data = response.body().string();
                        final Myres res = gson.fromJson(data, Myres.class);
                        System.out.println(res.token_type);
                        System.out.println(res.access_token);
                        System.out.println(res.expires_in);
                        String  sms = "{\"outboundSMSMessageRequest\":{\"address\": \"tel:+225"+Telephone+"\", \"senderAddress\":\"tel:+2250000\", \"outboundSMSTextMessage\":{ \"message\": \"VEUILLEZ VOUS CONNECTEZ A VOTRE APPLI CFLEX AVEC CE CODE TEMPORAIRE(5 min) DE 6 CHIFFRES : "+otp+" \"}}}";
                        okhttp3.RequestBody messageBody = okhttp3.RequestBody.create(sms, MediaType.parse("application/json"));
                        Request messagerequest = new Request.Builder().url("https://api.orange.com/smsmessaging/v1/outbound/tel%3A%2B2250000/requests")
                        .post(messageBody)
                        .addHeader("Authorization",res.token_type+" "+res.access_token)
                        .build();
    
                        try{
                            okhttp3.Response Newresponse = httpClient.newCall(messagerequest).execute();

                            JSONObject Newress = new JSONObject();
                            Newress.put("otp",otp);
                            if (response.isSuccessful()) {

                                return ResponseEntity.accepted().body(Newress);
                            }
                        }catch(Exception r){
                            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                        }
                        
                    }   
    
                } catch (Exception e) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
    
                return new ResponseEntity<Object>(HttpStatus.OK);
            }
}
