package projet.cflex.oda_cflex_smart_city1.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyPhone{

    private String telephone;

    @JsonCreator
    public MyPhone(@JsonProperty("telephone")String telephone){

        this.telephone = telephone;
    }

    public String getTelephone(){

        return this.telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
}
