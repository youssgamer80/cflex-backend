package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "point_arret")
public class PointArret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "statut")
    private Boolean statut;

}