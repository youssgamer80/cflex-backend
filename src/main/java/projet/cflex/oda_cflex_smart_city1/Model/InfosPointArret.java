package projet.cflex.oda_cflex_smart_city1.Model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "InfosPointArret")
public class InfosPointArret {

    private BigInteger id;
    private String nomPointArret;
    private Double latitude;
    private Double longitude;
    private Integer nombrePlaceDisponibleCouloir;
    private Integer vehiculeDisponibles;
    private List<VehiculeEnApproche> vehiculeEnApproche = new ArrayList<VehiculeEnApproche>();

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNomPointArret() {
        return nomPointArret;
    }

    public void setNomPointArret(String nomPointArret) {
        this.nomPointArret = nomPointArret;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getNombrePlaceDisponibleCouloir() {
        return nombrePlaceDisponibleCouloir;
    }

    public void setNombrePlaceDisponibleCouloir(Integer nombrePlaceDisponibleCouloir) {
        this.nombrePlaceDisponibleCouloir = nombrePlaceDisponibleCouloir;
    }

    public Integer getVehiculeDisponibles() {
        return vehiculeDisponibles;
    }

    public void setVehiculeDisponibles(Integer vehiculeDisponibles) {
        this.vehiculeDisponibles = vehiculeDisponibles;
    }

    public List<VehiculeEnApproche> getVehiculeEnApproche() {
        return vehiculeEnApproche;
    }

    public void setVehiculeEnApproche(List<VehiculeEnApproche> vehiculeEnApproche) {
        this.vehiculeEnApproche = vehiculeEnApproche;
    }
}
