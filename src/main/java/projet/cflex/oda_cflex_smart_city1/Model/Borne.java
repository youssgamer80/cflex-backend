package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;

@Entity
@Table(name = "borne")
public class Borne {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "libelle")
    private Integer libelle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_point_arret_fk")
    private PointArret idPointArretFk;

    @Column(name = "statut")
    private Boolean statut;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLibelle() {
        return libelle;
    }

    public void setLibelle(Integer libelle) {
        this.libelle = libelle;
    }

    public PointArret getIdPointArretFk() {
        return idPointArretFk;
    }

    public void setIdPointArretFk(PointArret idPointArretFk) {
        this.idPointArretFk = idPointArretFk;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut){

        this.statut= statut;
    }
}