package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;
import projet.cflex.oda_cflex_smart_city1.Model.TypeTransport;
import projet.cflex.oda_cflex_smart_city1.Model.Zone;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ligne")
public class Ligne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "depart", nullable = false)
    private String depart;

    @Column(name = "arrivee", nullable = false)
    private String arrivee;

    @Column(name = "depart_longitude", nullable = false)
    private double depart_longitude;

    @Column(name = "depart_latitude", nullable = false)
    private double depart_latitude;

    @Column(name = "arrivee_longitude", nullable = false)
    private double arrivee_longitude;
    
    @Column(name = "arrivee_latitude", nullable = false)
    private double arrivee_latitude;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_type_transport_fk", nullable = false)
    private TypeTransport idTypeTransportFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zone_fk", nullable = false)
    private Zone idZoneFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

}