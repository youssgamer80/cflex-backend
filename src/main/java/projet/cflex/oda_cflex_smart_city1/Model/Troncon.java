package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "troncon")
public class Troncon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_point_arret_A_fk", nullable = false)
    private PointArret idPointArretAFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_point_arret_B_fk", nullable = false)
    private PointArret idPointArretBFk;

    @Column(name = "distance", nullable = false)
    private Integer distance;

    @Column(name = "duree", nullable = false)
    private Integer duree;

    @Column(name = "tarif", nullable = false, precision = 10, scale = 2)
    private BigDecimal tarif;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ligne_fk")
    private Ligne idLigneFk;

    @Column(name = "rang")
    private Integer rang;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public PointArret getIdPointArretAFk() {
        return idPointArretAFk;
    }

    public void setIdPointArretAFk(PointArret idPointArretAFk) {
        this.idPointArretAFk = idPointArretAFk;
    }

    public PointArret getIdPointArretBFk() {
        return idPointArretBFk;
    }

    public void setIdPointArretBFk(PointArret idPointArretBFk) {
        this.idPointArretBFk = idPointArretBFk;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public BigDecimal getTarif() {
        return tarif;
    }

    public void setTarif(BigDecimal tarif) {
        this.tarif = tarif;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public Ligne getIdLigneFk() {
        return idLigneFk;
    }

    public void setIdLigneFk(Ligne idLigneFk) {
        this.idLigneFk = idLigneFk;
    }

    public Integer getRang() {
        return rang;
    }

    public void setRang(Integer rang) {
        this.rang = rang;
    }

}