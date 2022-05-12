package projet.cflex.oda_cflex_smart_city1.Model;

import projet.cflex.oda_cflex_smart_city1.Model.Troncon;
import projet.cflex.oda_cflex_smart_city1.Model.Usager;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "emprunter")
public class Emprunter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_troncon_fk", nullable = false)
    private Troncon idTronconFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vehicule_fk", nullable = false)
    private Vehicule idVehiculeFk;

    @Column(name = "date_arrivee", nullable = false)
    private Instant dateArrivee;

    @Column(name = "date_depart", nullable = false)
    private Instant dateDepart;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usager_fk", nullable = false)
    private Usager idUsagerFk;

    @Column(name = "date", nullable = false)
    private Instant date;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Troncon getIdTronconFk() {
        return idTronconFk;
    }

    public void setIdTronconFk(Troncon idTronconFk) {
        this.idTronconFk = idTronconFk;
    }

    public Vehicule getIdVehiculeFk() {
        return idVehiculeFk;
    }

    public void setIdVehiculeFk(Vehicule idVehiculeFk) {
        this.idVehiculeFk = idVehiculeFk;
    }

    public Instant getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Instant dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Instant getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Instant dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Usager getIdUsagerFk() {
        return idUsagerFk;
    }

    public void setIdUsagerFk(Usager idUsagerFk) {
        this.idUsagerFk = idUsagerFk;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

}