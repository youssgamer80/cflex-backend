package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "vehicule")
@SQLDelete(sql = "UPDATE vehicule SET statut = true WHERE id=?")
@FilterDef(name = "deletedVehiculeFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedVehiculeFilter", condition = "statut = :isDeleted")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "immatriculation")
    private String immatriculation;

    @Column(name = "marque")
    private String marque;

    @Column(name = "modele")
    private String modele;

    @Column(name = "id_proprietaire_fk")
    private Integer idProprietaireFk;

    @Column(name = "statut")
    private Boolean statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_transport_fk")
    private TypeTransport idTypeTransportFk;

    @Column(name = "nb_place")
    private Integer nbPlace;

    /*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zone_fk", nullable = false)
    private Zone idZoneFk;*/

    @Column(name = "carte_grise", nullable = false)
    private String carteGrise;

}