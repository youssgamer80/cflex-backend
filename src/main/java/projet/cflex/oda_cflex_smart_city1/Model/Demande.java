package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;


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

    @ManyToOne(targetEntity = Proprietaire.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_proprietaire_fk", insertable = false, updatable = false)
    //@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
    private Proprietaire proprietaire;


    @Column(name = "id_proprietaire_fk")
    private int idProprietaireFk;


    @Column(name = "date", nullable = false)
    private Instant date;

    @ManyToOne(targetEntity = TypeTransport.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_type_transport_fk", insertable = false, updatable = false)
    private TypeTransport TypeTransportFk;

    @Column(name = "id_type_transport_fk")
    private int idTypeTransportFk;


    @ManyToOne(targetEntity = Zone.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_zone_fk", insertable = false, updatable = false)
    private Zone ZoneFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeDemande() {
        return codeDemande;
    }

    public void setCodeDemande(String codeDemande) {
        this.codeDemande = codeDemande;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public int getIdProprietaireFk() {
        return idProprietaireFk;
    }

    public void setIdProprietaireFk(int idProprietaireFk) {
        this.idProprietaireFk = idProprietaireFk;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public int getIdTypeTransportFk() {
        return idTypeTransportFk;
    }

    public void setIdTypeTransportFk(int idTypeTransportFk) {
        this.idTypeTransportFk = idTypeTransportFk;
    }

    public int getIdZoneFk() {
        return idZoneFk;
    }

    public void setIdZoneFk(int idZoneFk) {
        this.idZoneFk = idZoneFk;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    @Column(name = "id_zone_fk")
    private int idZoneFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = Boolean.FALSE;

}
