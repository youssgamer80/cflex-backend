package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "stationner")
public class Stationner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehicule_fk")
    private Vehicule idVehiculeFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_point_arret_fk")
    private PointArret idPointArretFk;

    @Column(name = "date", nullable = false)
    private Instant date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_client_fk", nullable = false)
    private Usager idClientFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vehicule getIdVehiculeFk() {
        return idVehiculeFk;
    }

    public void setIdVehiculeFk(Vehicule idVehiculeFk) {
        this.idVehiculeFk = idVehiculeFk;
    }

    public PointArret getIdPointArretFk() {
        return idPointArretFk;
    }

    public void setIdPointArretFk(PointArret idPointArretFk) {
        this.idPointArretFk = idPointArretFk;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Usager getIdClientFk() {
        return idClientFk;
    }

    public void setIdClientFk(Usager idClientFk) {
        this.idClientFk = idClientFk;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

}