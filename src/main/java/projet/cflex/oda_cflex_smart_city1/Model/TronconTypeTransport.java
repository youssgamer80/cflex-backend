package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "troncon_type_transport")
public class TronconTypeTransport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_troncon_fk", nullable = false)
    private Troncon idTronconFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_type_transport_fk", nullable = false)
    private TypeTransport idTypeTransportFk;

    @Column(name = "prix", nullable = false)
    private Double prix;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;
    
}
