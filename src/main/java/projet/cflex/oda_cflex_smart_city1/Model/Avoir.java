package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;

@Entity
@Table(name = "avoir")
public class Avoir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_itineraire_fk")
    private Itineraire idItineraireFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mode_deplacement_fk")
    private ModeDeplacement idModeDeplacementFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

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

    public ModeDeplacement getIdModeDeplacementFk() {
        return idModeDeplacementFk;
    }

    public void setIdModeDeplacementFk(ModeDeplacement idModeDeplacementFk) {
        this.idModeDeplacementFk = idModeDeplacementFk;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

}