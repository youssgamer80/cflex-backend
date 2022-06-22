package projet.cflex.oda_cflex_smart_city1.Model;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
@Entity

@Table(name = "vehicule")
@SQLDelete(sql = "UPDATE vehicule SET statut = false WHERE id=?")
@FilterDef(name = "deletedVehiculeFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedVehiculeFilter", condition = "statut = :isDeleted")
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "immatriculation", nullable = false)
    private String immatriculation;

    @Column(name = "marque", nullable = false)
    private String marque;

    @Column(name = "modele", nullable = false)
    private String modele;

/*
    @Column(name = "token")
    private String token;
*/

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_proprietaire_fk", nullable = false)
    private Proprietaire proprietaire;

    @Column(name = "statut", nullable = false)
    private Boolean statut;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_transport_fk", nullable = false)
    private TypeTransport idTypeTransportFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_zone_fk", nullable = false)
    private Zone zone;

    @Column(name = "nb_place", nullable = false)
    private Integer nbPlace;
    @Column(name = "carte_grise", nullable = false)
    private String carteGrise;

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

/*    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }*/

    public void setModele(String modele) {
        this.modele = modele;
    }
    public Proprietaire getProprietaire() {
        return proprietaire;
    }
    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
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
    public String getCarteGrise() {
        return carteGrise;
    }
    public void setCarteGrise(String carteGrise) {
        this.carteGrise = carteGrise;
    }

    public Zone getZone() {return zone;}
    public void setZone(Zone zone) {this.zone = zone;}
}