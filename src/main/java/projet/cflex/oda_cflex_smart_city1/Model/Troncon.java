package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;

import javax.persistence.*;

//@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "troncon")
public class Troncon {

    public Troncon() {
    }

    public Troncon(String nom, PointArret idPointArretAFk, PointArret idPointArretBFk, Double distance, Integer duree, Boolean statut, Ligne idLigneFk) {
        this.nom = nom;
        this.idPointArretAFk = idPointArretAFk;
        this.idPointArretBFk = idPointArretBFk;
        this.distance = distance;
        this.duree = duree;
        this.statut = statut;
        this.idLigneFk = idLigneFk;
    }
   

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
    private Double distance;

    @Column(name = "duree", nullable = false)
    private Integer duree;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ligne_fk")
    private Ligne idLigneFk;

}