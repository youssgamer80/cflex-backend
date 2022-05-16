package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;

@Entity
@Table(name = "appartenir")
public class Appartenir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ligne_fk", nullable = false)
    private Ligne idLigneFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_troncon_fk", nullable = false)
    private Troncon idTronconFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ligne getIdLigneFk() {
        return idLigneFk;
    }

    public void setIdLigneFk(Ligne idLigneFk) {
        this.idLigneFk = idLigneFk;
    }

    public Troncon getIdTronconFk() {
        return idTronconFk;
    }

    public void setIdTronconFk(Troncon idTronconFk) {
        this.idTronconFk = idTronconFk;
    }

}