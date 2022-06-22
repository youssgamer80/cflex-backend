package projet.cflex.oda_cflex_smart_city1.Model;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "proprietaire")
@SQLDelete(sql = "UPDATE proprietaire SET statut = false WHERE id=?")
@FilterDef(name = "deletedProprietaireFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedProprietaireFilter", condition = "statut = :isDeleted")
public class Proprietaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "statut")
    private Boolean statut;

    @Column(name = "permis")
    private String permis;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "genre", nullable = false, length = 1)
    private String genre;

    @Column(name = "lieu_naissance")
    private String lieuNaissance;

    @Column(name = "lieu_residence", nullable = false)
    private String lieuResidence;

    @Column(name = "piece_identite", nullable = false)
    private String pieceIdentite;
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

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public String getPermis() {
        return permis;
    }

    public void setPermis(String permis) {
        this.permis = permis;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getLieuResidence() {
        return lieuResidence;
    }

    public void setLieuResidence(String lieuResidence) {
        this.lieuResidence = lieuResidence;
    }

    public String getPieceIdentite() {
        return pieceIdentite;
    }

    public void setPieceIdentite(String pieceIdentite) {
        this.pieceIdentite = pieceIdentite;
    }


}