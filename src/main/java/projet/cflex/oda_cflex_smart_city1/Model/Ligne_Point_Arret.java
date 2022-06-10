package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;
import javax.persistence.*;

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

    @ManyToOne(targetEntity = Ligne.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ligne_fk")
    private Ligne idLigneFk;

    @ManyToOne(targetEntity = PointArret.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_point_arret_fk")
    private PointArret idPointArretFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;
    
    
}
