package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;

import javax.persistence.*;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "trackergps")
@SQLDelete(sql = "UPDATE trackergps SET statut = false WHERE id=?")
@FilterDef(name = "deletedTrackergpsFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedTrackergpsFilter", condition = "statut = :isDeleted")
public class Trackergps {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "id_vehicule_fk", nullable = false)
    // private Vehicule idVehiculeFk;

    @Column(name = "id_vehicule_fk", nullable = true)
    private Integer idVehiculeFk;

    

    @Column(name = "statut", nullable = false)
    private Boolean statut = true;


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

    // public Vehicule getIdVehiculeFk() {
    //     return idVehiculeFk;
    // }

    // public void setIdVehiculeFk(Vehicule idVehiculeFk) {
    //     this.idVehiculeFk = idVehiculeFk;
    // }

    public Integer getIdVehiculeFk() {
        return this.idVehiculeFk;
    }

    public void setIdVehiculeFk(Integer idVehiculeFk) {
        this.idVehiculeFk = idVehiculeFk;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }
}