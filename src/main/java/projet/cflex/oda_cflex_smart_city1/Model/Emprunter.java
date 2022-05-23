package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;
import projet.cflex.oda_cflex_smart_city1.Model.Troncon;
import projet.cflex.oda_cflex_smart_city1.Model.Usager;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;

import javax.persistence.*;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "emprunter")
public class Emprunter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_troncon_fk", nullable = false)
    private Troncon idTronconFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vehicule_fk", nullable = false)
    private Vehicule idVehiculeFk;

    @Column(name = "date_arrivee", nullable = false)
    private Instant dateArrivee;

    @Column(name = "date_depart", nullable = false)
    private Instant dateDepart;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_client_fk", nullable = false)
    private Usager idClientFk;

    @Column(name = "date", nullable = false)
    private Instant date;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

}