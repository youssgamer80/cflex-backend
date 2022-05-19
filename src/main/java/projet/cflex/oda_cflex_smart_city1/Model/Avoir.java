package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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

}