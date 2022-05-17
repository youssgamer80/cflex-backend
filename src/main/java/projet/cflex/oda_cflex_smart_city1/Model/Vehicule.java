package projet.cflex.oda_cflex_smart_city1.Model;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proprietaire_fk")
    private Proprietaire idProprietaireFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_transport_fk")
    private TypeTransport idTypeTransportFk;

    @Column(name = "nb_place")
    private Integer nbPlace;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zone_fk", nullable = false)
    private Zone idZoneFk;

    @Column(name = "cartegrise", nullable = false)
    private String cartegrise;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_demande_fk", nullable = false)
    private Demande idDemandeFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Proprietaire getIdProprietaireFk() {
        return idProprietaireFk;
    }

    public void setIdProprietaireFk(Proprietaire idProprietaireFk) {
        this.idProprietaireFk = idProprietaireFk;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public TypeTransport getIdTypeTransportFk() {
        return idTypeTransportFk;
    }

    public void setIdTypeTransportFk(TypeTransport idTypeTransportFk) {
        this.idTypeTransportFk = idTypeTransportFk;
    }

    public Integer getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(Integer nbPlace) {
        this.nbPlace = nbPlace;
    }

    public Zone getIdZoneFk() {
        return idZoneFk;
    }

    public void setIdZoneFk(Zone idZoneFk) {
        this.idZoneFk = idZoneFk;
    }

    public String getCarteGrise() {
        return cartegrise;
    }

    public void setCarteGrise(String cartegrise) {
        this.cartegrise = cartegrise;
    }

    public Demande getIdDemandeFk() {
        return idDemandeFk;
    }

    public void setIdDemandeFk(Demande idDemandeFk) {
        this.idDemandeFk = idDemandeFk;
    }

}