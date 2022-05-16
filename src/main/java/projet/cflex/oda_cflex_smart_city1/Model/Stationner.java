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
    @JoinColumn(name = "id_usager_fk", nullable = false)
    private Usager idUsagerFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

    @Column(name = "type_utilisateur", nullable = false, length = 11)
    private String typeUtilisateur;

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

    public Usager getIdUsagerFk() {
        return idUsagerFk;
    }

    public void setIdUsagerFk(Usager idUsagerFk) {
        this.idUsagerFk = idUsagerFk;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public String getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public void setTypeUtilisateur(String typeUtilisateur) {
        this.typeUtilisateur = typeUtilisateur;
    }

}