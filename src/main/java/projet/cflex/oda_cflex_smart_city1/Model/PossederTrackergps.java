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
@Table(name = "`posseder-trackergps`")
public class PossederTrackergps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "periode", nullable = false)
    private Instant periode;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

    @Column(name = "id_vehicule_fk", nullable = false)
    private Integer idVehiculeFk;

    @Column(name = "id_trackergps_fk", nullable = false)
    private Integer idTrackergpsFk;

}