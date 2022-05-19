package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "point_arret")
public class PointArret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

<<<<<<< HEAD
    @Column(name = "nom")
    private String nom;

    public Boolean isStatut() {
        return this.statut;
    }

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLatitude() {
        return latitude;
    }
=======
    @Column(name = "nom", nullable = false)
    private String nom;
>>>>>>> f0f14fa6c08a0c3c387326026ec3b5a0b9a5caef

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "statut")
    private Boolean statut;

}