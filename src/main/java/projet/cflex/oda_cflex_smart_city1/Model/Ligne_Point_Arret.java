package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;
import projet.cflex.oda_cflex_smart_city1.Model.PointArret;
import projet.cflex.oda_cflex_smart_city1.Model.Ligne;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ligne_point_arret")
public class Ligne_Point_Arret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ligne_fk", nullable = false)
    private Ligne idLigneFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_point_arret_fk", nullable = false)
    private PointArret idPointArretFk;

    @Column(name = "rang", nullable = false)
    private Integer rang;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

}