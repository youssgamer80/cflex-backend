package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// @JsonIgnoreProperties({"idVehiculeFk"})
@Entity
@Table(name = "trackergps")
public class Trackergps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vehicule_fk", nullable = false)
    private Vehicule idVehiculeFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Vehicule getIdVehiculeFk() {
        return idVehiculeFk;
    }

    public void setIdVehiculeFk(Vehicule idVehiculeFk) {
        this.idVehiculeFk = idVehiculeFk;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

}