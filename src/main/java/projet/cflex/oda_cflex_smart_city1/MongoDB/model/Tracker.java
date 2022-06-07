package projet.cflex.oda_cflex_smart_city1.MongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tracker")
public class Tracker {
  @Id
  private String id;

  private String idtracker;
  private String immatriculation;
  private Double lattitude;
  private Double longitude;
  private String typetransport;

  public Tracker() {

  }

  public Tracker(String id, String idtracker, String immatriculation, Double lattitude, Double longitude, String typetransport) {
    this.id = id;
    this.idtracker = idtracker;
    this.immatriculation = immatriculation;
    this.lattitude = lattitude;
    this.longitude = longitude;
    this.typetransport = typetransport;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public Double getLattitude() {
    return lattitude;
  }

  public void setLattitude(Double lattitude) {
    this.lattitude = lattitude;
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

  @Override
  public String toString() {
    return "Tracker [id=" + id + ", idtracker="+idtracker +",immatriculation="+immatriculation+", lattitude=" + lattitude + ", longitude=" + longitude + ", Type Transport=" + typetransport + "]";
  }
}
