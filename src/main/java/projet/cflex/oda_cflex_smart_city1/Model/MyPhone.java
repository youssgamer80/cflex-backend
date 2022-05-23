package projet.cflex.oda_cflex_smart_city1.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyPhone{

    private String telephone;
    private String signature;

    @JsonCreator
    public MyPhone(@JsonProperty("telephone")String telephone, @JsonProperty("signature")String signature){

        this.telephone = telephone;
        this.signature = signature;
    }

    public String getTelephone(){

        return this.telephone;
    }

    public void setTelephone(String telephone) {

        this.telephone = telephone;
    }
    
    public String getSignature(){

        return this.signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
