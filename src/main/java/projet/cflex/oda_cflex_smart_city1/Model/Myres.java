package projet.cflex.oda_cflex_smart_city1.Model;

public class Myres{

    public String access_token;
    public String token_type;
    public int expires_in;

    public Myres(String access_token, String token_type, int expires_in){

        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
    }

    public String getAccessToken(){
        return this.access_token;
    }

    public void setAccessToken(String access_token){

        this.access_token = access_token;
    }

    public String getTokenType(){
        return this.token_type;
    }

    public void setTokenType(String token_type){

        this.token_type = token_type;
    }

    public int getExpiresIn(){
        return this.expires_in;
    }

    public void setEpiresIn(int expires_in){

        this.expires_in = expires_in;
    }
}