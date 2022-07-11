package projet.cflex.oda_cflex_smart_city1.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "couloir")
public class Couloir {
  @Id
  private String id;

  @JsonProperty("idcouloir")
  private String idcouloir;
  @JsonProperty("nb_person")
  private Integer nb_person;
  @JsonProperty("nb_place")
  private Integer nb_place;

  public Couloir(String idcouloir, Integer nb_person, Integer nb_place) {

  }
  @JsonCreator
  public Couloir(String id,String idcouloir, Integer nb_person, Integer nb_place) {

    this.id = id;
    this.idcouloir = idcouloir;
    this.nb_person = nb_person;
    this.nb_place = nb_place;

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

  @Override
  public String toString() {
    return "Couloir [id=" + id + ", idcouloir="+idcouloir +",nb_person="+nb_person+", nb_place=" + nb_place +"]";
  }
}
