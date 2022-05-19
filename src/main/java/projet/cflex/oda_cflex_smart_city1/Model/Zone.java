package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "zone")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_type_zone_fk", nullable = false)
    private TypeZone idTypeZoneFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zoneparent")
    private Zone zoneparent;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

}