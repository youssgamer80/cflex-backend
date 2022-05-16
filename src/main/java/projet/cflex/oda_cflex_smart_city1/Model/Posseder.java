package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "posseder")
public class Posseder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "periode", nullable = false)
    private Instant periode;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vehicule_fk", nullable = false)
    private Vehicule idVehiculeFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_trackergps_fk", nullable = false)
    private Trackergp idTrackergpsFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getPeriode() {
        return periode;
    }

    public void setPeriode(Instant periode) {
        this.periode = periode;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public Vehicule getIdVehiculeFk() {
        return idVehiculeFk;
    }

    public void setIdVehiculeFk(Vehicule idVehiculeFk) {
        this.idVehiculeFk = idVehiculeFk;
    }

    public Trackergp getIdTrackergpsFk() {
        return idTrackergpsFk;
    }

    public void setIdTrackergpsFk(Trackergp idTrackergpsFk) {
        this.idTrackergpsFk = idTrackergpsFk;
    }

}