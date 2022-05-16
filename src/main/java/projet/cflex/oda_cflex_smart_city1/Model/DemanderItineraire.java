package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "demander_itineraire")
public class DemanderItineraire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_itineraire_fk", nullable = false)
    private Itineraire idItineraireFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usager_fk", nullable = false)
    private Usager idUsagerFk;

    @Column(name = "date", nullable = false)
    private Instant date;

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

}