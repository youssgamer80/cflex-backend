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
@Table(name = "stationner")
public class Stationner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehicule_fk")
    private Vehicule idVehiculeFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_point_arret_fk")
    private PointArret idPointArretFk;

    @Column(name = "date", nullable = false)
    private Instant date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_client_fk", nullable = false)
    private Usager idClientFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

}