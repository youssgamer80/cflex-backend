package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "demande")
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "libelle")
    private static String libelle;

    @Column(name = "etat")
    private Boolean etat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_proprietaire_fk", nullable = false)
    private Proprietaire idProprietaireFk;

    @Column(name = "date", nullable = false)
    private Instant date;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "lieu_residence", nullable = false)
    private String lieuResidence;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "marque", nullable = false)
    private String marque;

    @Column(name = "cni", nullable = false)
    private String cni;

    @Column(name = "permis", nullable = false)
    private String permis;

    @Column(name = "carte_grise", nullable = false)
    private String carteGrise;

    @Column(name = "assurance")
    private String assurance;

    @Column(name = "immatriculation", nullable = false, length = 8)
    private String immatriculation;

    @Column(name = "modele", nullable = false)
    private String modele;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_type_transport_fk", nullable = false)
    private TypeTransport idTypeTransportFk;

    @Column(name = "nbre_place", nullable = false)
    private Integer nbrePlace;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zone_fk", nullable = false)
    private Zone zoneFk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        Demande.libelle = libelle;
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

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLieuResidence() {
        return lieuResidence;
    }

    public void setLieuResidence(String lieuResidence) {
        this.lieuResidence = lieuResidence;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getPermis() {
        return permis;
    }

    public void setPermis(String permis) {
        this.permis = permis;
    }

    public String getCarteGrise() {
        return carteGrise;
    }

    public void setCarteGrise(String carteGrise) {
        this.carteGrise = carteGrise;
    }

    public String getAssurance() {
        return assurance;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public TypeTransport getIdTypeTransportFk() {
        return idTypeTransportFk;
    }

    public void setIdTypeTransportFk(TypeTransport idTypeTransportFk) {
        this.idTypeTransportFk = idTypeTransportFk;
    }

    public Integer getNbrePlace() {
        return nbrePlace;
    }

    public void setNbrePlace(Integer nbrePlace) {
        this.nbrePlace = nbrePlace;
    }

    public Zone getZoneFk() {
        return zoneFk;
    }

    public void setZoneFk(Zone zoneFk) {
        this.zoneFk = zoneFk;
    }

}