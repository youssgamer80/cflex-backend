package projet.cflex.oda_cflex_smart_city1.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import java.sql.Time;

@Document(collection = "position_vehicule")
public class PositionVehicule {
    @Transient
    public static final String positionSequence = "position_sequence";
    @Id
    private Long id;

    @Indexed(unique = true)
    @Field(value = "id_tracker")
    private Long idTracker;
    @Indexed(unique = true)
    @Field(value = "title")
    private String title;

    @Field(value = "description")
    private String description;

    @Field(value = "infobox")
    private Boolean infobox;

    @Field(value = "fill")
    private Boolean fill;

    @Field(value="heure")
    private Time heure;

    @Field(value = "type")
    private String type;

    @Field(value = "coordinates")
    private Double coordinates;

    public Long getIdTracker() {
        return idTracker;
    }

    public void setIdTracker(Long idTracker) {
        this.idTracker = idTracker;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getInfobox() {
        return infobox;
    }

    public void setInfobox(Boolean infobox) {
        this.infobox = infobox;
    }

    public Boolean getFill() {
        return fill;
    }

    public void setFill(Boolean fill) {
        this.fill = fill;
    }

    public Time getHeure() {
        return heure;}

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Double coordinates) {
        this.coordinates = coordinates;
    }

}