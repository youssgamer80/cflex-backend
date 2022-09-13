package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;


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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_depart_fk", nullable = false)
    private PointArret idDepartFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_arrivee_fk", nullable = false)
    private PointArret idArriveeFk;

    @Column(name = "tarif", nullable = false)
    private double tarif;

    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "id_type_transport_fk", nullable = false)
    // private TypeTransport idTypeTransportFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zone_fk", nullable = false)
    private Zone idZoneFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

}