package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;

@Entity
@Table(name = "chauffeur")
public class Chauffeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "cni")
    private String cni;

    @Column(name = "permis")
    private String permis;

    @Column(name = "taux_commission")
    private Double tauxCommission;

    @Column(name = "telephone", length = 10)
    private String telephone;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

    @Column(name = "genre", nullable = false, length = 2)
    private String genre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getTauxCommission() {
        return tauxCommission;
    }

    public void setTauxCommission(Double tauxCommission) {
        this.tauxCommission = tauxCommission;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}