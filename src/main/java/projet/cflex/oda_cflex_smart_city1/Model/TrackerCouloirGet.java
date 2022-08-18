package projet.cflex.oda_cflex_smart_city1.Model;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class TrackerCouloirGet {
    @Id
    private BigInteger _id;

    private String idcouloir;
    private Integer nb_person;
    private String idtracker;
    private Double latitude;
    private Double longitude;
    private String immatriculation;
    private String typetransport;
    private Integer nbVehiculeApproche;
    private String _class;

    public BigInteger getId() {
        return _id;
    }

    public void setId(BigInteger _id) {
        this._id = _id;
    }

    public String getIdcouloir() {
        return idcouloir;
    }

    public void setIdcouloir(String idcouloir) {
        this.idcouloir = idcouloir;
    }

    public Integer getNbPerson() {
        return nb_person;
    }

    public void setNbPerson(Integer nb_person) {
        this.nb_person = nb_person;
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

    public String gettypetransport() {
        return typetransport;
    }

    public void settypetransport(String typetransport) {
        this.typetransport = typetransport;
    }

    public Integer getNbVehiculeApproche() {
        return nbVehiculeApproche;
    }

    public void setNbVehiculeApproche(Integer nbVehiculeApproche) {
        this.nbVehiculeApproche = nbVehiculeApproche;
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

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    @Override
    public String toString() {
        return "TrackerCouloir [id=" + _id + ", idcouloir=" + idcouloir + ",nb_person=" + nb_person + ", idtracker="
                + idtracker + ", immatriculation=" + immatriculation + ", latitude="
                + latitude + ", longitude=" + longitude + ", TypeTransport=" + typetransport + ", nb_vehicule_approche="
                + nbVehiculeApproche + "]";
    }
}