package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "itineraire")
public class Itineraire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "temps", nullable = false)
    private Instant temps;

    @Column(name = "tarif")
    private Double tarif;

    @Column(name = "distance")
    private Integer distance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trajet_fk")
    private Trajet idTrajetFk;
    

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getTemps() {
        return temps;
    }

    public void setTemps(Instant temps) {
        this.temps = temps;
    }

    public Double getTarif() {
        return tarif;
    }

    public void setTarif(Double tarif) {
        this.tarif = tarif;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Trajet getIdTrajetFk() {
        return idTrajetFk;
    }

    public void setIdTrajetFk(Trajet idTrajetFk) {
        this.idTrajetFk = idTrajetFk;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

}