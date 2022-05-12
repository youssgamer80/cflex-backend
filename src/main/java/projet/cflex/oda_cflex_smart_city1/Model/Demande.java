package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.time.Instant;

/**
 * @Data is a convenient shortcut annotation that bundles the features of 
 * @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
 */
@Entity
@Table(name = "demande")
@Data
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "libelle")
    @NotEmpty(message = "libelle is required")
    private String libelle;

    @Column(name = "etat")
    private Boolean etat;
    
    @NotEmpty(message = "proprietaire is required")
    @JsonProperty("id_proprietaire_fk")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_proprietaire_fk", nullable = false)
    private Proprietaire idProprietaireFk;

    @NotEmpty(message = "date is required")
    @Column(name = "date", nullable = false)
    private Instant date;

    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "id_type_transport_fk", nullable = false)
    // private TypeTransport idTypeTransportFk;

    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "zone_fk", nullable = false)
    // private Zone zoneFk;


    @Column(name = "statut", nullable = false)
    private Boolean statut = true;

    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "id_vehicule_fk", nullable = false)
    // private Vehicule idVehiculeFk;

}