package projet.cflex.oda_cflex_smart_city1.Model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.RandomStringUtils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

public class Demande{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code_demande")
    private String codeDemande;

    @Column(name = "etat")
    private Boolean etat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proprietaire_fk")
    private Proprietaire idProprietaireFk;;


    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "immatriculation", nullable = false)
    private String Immatriculation;

    @Column(name = "marque", nullable = false)
    private String marque;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "nb_place", nullable = false)
    private Integer nbPlace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_transport_fk")
    private TypeTransport idTypeTransportFk;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_zone_fk")
    private Zone idZoneFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = Boolean.FALSE;

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

    public Proprietaire getIdProprietaireFk() {
        return idProprietaireFk;
    }

    public void setIdProprietaireFk(Proprietaire idProprietaireFk) {
        this.idProprietaireFk = idProprietaireFk;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getImmatriculation() {
        return Immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.Immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(Integer nbPlace) {
        this.nbPlace = nbPlace;
    }

    public TypeTransport getIdTypeTransportFk() {
        return idTypeTransportFk;
    }

    public void setIdTypeTransportFk(TypeTransport idTypeTransportFk) {
        this.idTypeTransportFk = idTypeTransportFk;
    }

    public Zone getIdZoneFk() {
        return idZoneFk;
    }

    public void setIdZoneFk(Zone idZoneFk) {
        this.idZoneFk = idZoneFk;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }
}
