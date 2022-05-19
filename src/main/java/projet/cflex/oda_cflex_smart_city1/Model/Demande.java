package projet.cflex.oda_cflex_smart_city1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "demande", indexes = {
        @Index(name = "idx_demande_id_zone_fk", columnList = "id_zone_fk"),
        @Index(name = "idx_demande_id_type_transport_fk", columnList = "id_type_transport_fk"),
        @Index(name = "idx_demande_id_proprietaire_fk", columnList = "id_proprietaire_fk"),

})
@SQLDelete(sql = "UPDATE demande SET statut = true WHERE id=?")
@Where(clause = "statut=false")
public class Demande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code_demande")
    private String codeDemande;

    @Column(name = "etat")
    private Boolean etat;
    @JsonIgnore
    @ManyToOne(targetEntity = Proprietaire.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_proprietaire_fk", insertable = false, updatable = false)
    //@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
    private Proprietaire proprietaire;


    @Column(name = "id_proprietaire_fk")
    private int idProprietaireFk;


    @Column(name = "date", nullable = false)
    private Instant date;

    @Column(name = "immatriculation", nullable = false)
    private String Immatriculation;

    @Column(name = "marque", nullable = false)
    private String marque;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "nb_place", nullable = false)
    private Integer nombreDePlace;

    @JsonIgnore
    @ManyToOne(targetEntity = TypeTransport.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_type_transport_fk", insertable = false, updatable = false)
    private TypeTransport TypeTransportFk;

    @Column(name = "id_type_transport_fk")
    private int idTypeTransportFk;

    @JsonIgnore
    @ManyToOne(targetEntity = Zone.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_zone_fk", insertable = false, updatable = false)
    private Zone ZoneFk;

    @Column(name = "id_zone_fk")
    private int idZoneFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = Boolean.FALSE;

}
