package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;
import javax.persistence.*;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "itineraire")
public class Itineraire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "temps", nullable = false)
    private Instant temps;

    @Column(name = "tarif")
    private Double tarif;

    @Column(name = "distance")
    private Integer distance;

    @ManyToOne(targetEntity = Trajet.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_trajet_fk")
    private Trajet idTrajetFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

}