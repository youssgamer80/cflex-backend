package projet.cflex.oda_cflex_smart_city1.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrackerCouloir {

    @Id
    private String id;

    @JsonProperty("idcouloir")
    private String idcouloir;
    @JsonProperty("nb_person")
    private Integer nb_person;
    @JsonProperty("nb_place")
    private Integer nb_place;
    @JsonProperty("idtracker")
    private String idtracker;
    @JsonProperty("immatriculation")
    private String immatriculation;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("typetransport")
    private String typetransport;
    @JsonProperty("nbVehiculeApproche")
    private Integer nbVehiculeApproche;

    public TrackerCouloir(String idcouloir, Integer nb_person, String idtracker,
            String immatriculation, Double latitude, Double longitude, String typetransport,
            Integer nbVehiculeApproche) {

        this.idcouloir = idcouloir;
        this.nb_person = nb_person;
        this.nbVehiculeApproche = nbVehiculeApproche;
        this.idtracker = idtracker;
        this.immatriculation = immatriculation;
        this.latitude = latitude;
        this.longitude = longitude;
        this.typetransport = typetransport;

    }

    @JsonCreator
    public TrackerCouloir(String id, String idcouloir, Integer nb_person, String idtracker,
            String immatriculation, Double latitude, Double longitude, String typetransport,
            Integer nbVehiculeApproche) {

        this.id = id;
        this.idcouloir = idcouloir;
        this.nb_person = nb_person;
        this.nbVehiculeApproche = nbVehiculeApproche;
        this.idtracker = idtracker;
        this.immatriculation = immatriculation;
        this.latitude = latitude;
        this.longitude = longitude;
        this.typetransport = typetransport;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCouloir() {
        return idcouloir;
    }

    public void setIdidcouloir(String idcouloir) {
        this.idcouloir = idcouloir;
    }

    public Integer getNbPerson() {
        return nb_person;
    }

    public void setNbPerson(Integer nb_person) {
        this.nb_person = nb_person;
    }

    public Integer getNbPlace() {
        return nb_place;
    }

    public void setNbPlace(Integer nb_place) {
        this.nb_place = nb_place;
    }

    public String getIdtracker() {
        return idtracker;
    }

    public void setIdtracker(String idtracker) {
        this.idtracker = idtracker;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Double getlatitude() {
        return latitude;
    }

    public void setlatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTypetransport() {
        return typetransport;
    }

    public void setTypetransport(String typetransport) {
        this.typetransport = typetransport;
    }

    public Integer getNbVehiculeApproche() {
        return nbVehiculeApproche;
    }

    public void setNbVehiculeApproche(Integer nbVehiculeApproche) {
        this.nbVehiculeApproche = nbVehiculeApproche;
    }

    @Override
    public String toString() {
        return "TrackerCouloir [id=" + id + ", idcouloir=" + idcouloir + ",nb_person=" + nb_person + ", idtracker="
                + idtracker + ", immatriculation=" + immatriculation + ", latitude="
                + latitude + ", longitude=" + longitude + ", TypeTransport=" + typetransport + ", nb_vehicule_approche="
                + nbVehiculeApproche + "]";
    }
}