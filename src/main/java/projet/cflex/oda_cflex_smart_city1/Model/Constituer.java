package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;

@Entity
@Table(name = "constituer")
public class Constituer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_itineraire_fk", nullable = false)
    private Itineraire idItineraireFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_troncon_fk", nullable = false)
    private Troncon idTronconFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Itineraire getIdItineraireFk() {
        return idItineraireFk;
    }

    public void setIdItineraireFk(Itineraire idItineraireFk) {
        this.idItineraireFk = idItineraireFk;
    }

    public Troncon getIdTronconFk() {
        return idTronconFk;
    }

    public void setIdTronconFk(Troncon idTronconFk) {
        this.idTronconFk = idTronconFk;
    }

}