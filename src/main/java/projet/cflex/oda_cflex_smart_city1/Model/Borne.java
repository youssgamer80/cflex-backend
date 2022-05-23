package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "borne")
public class Borne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "libelle", nullable = true)
    private String libelle;

    @ManyToOne(targetEntity = PointArret.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_point_arret_fk")
    private Integer idPointArretFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

}