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
    @JoinColumn(name = "id_client_fk", nullable = false)
    private Usager idClientFk;

    @Column(name = "date", nullable = false)
    private Instant date;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

}