package projet.cflex.oda_cflex_smart_city1.Model;

import com.mongodb.internal.connection.Time;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.mongodb.internal.connection.Time;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Position{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private Timestamp dateCreate;

    private String typeUser;

    private Double longitude;

    private Double latitude;

    public  Position(Timestamp dateCreate, String typeUser, Double longitude, Double latitude){

        this.dateCreate = dateCreate;

        this.typeUser = typeUser;

        this.longitude = longitude;

        this.latitude = latitude;
    }
    
    public void setUserId(Integer userId) {

        this.userId = userId;
    }

    public Integer getUserId() {

        return userId;
    }
    
    public void setDateCreate(Timestamp dateCreate) {

        this.dateCreate = dateCreate;
    }
    
    public Timestamp getDateCreate() {

        return dateCreate;
    }
    
    public void setTypeUser(String typeUser) {

        this.typeUser = typeUser;
    }
    
    public String getTypeUser() {

        return typeUser;
    }
    
    public void setLongitude(Double longitude) {

        this.longitude = longitude;
    }
    
    public Double getLongitude() {

        return longitude;
    }
    
    public void setLatitude(Double latitude) {

        this.latitude = latitude;
    }
    
    public Double getLatitude() {

        return latitude;
    }
    
}
