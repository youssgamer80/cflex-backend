package projet.cflex.oda_cflex_smart_city1.Model;

import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "borne")
@SQLDelete(sql = "UPDATE borne SET statut = false WHERE id=?")
@FilterDef(name = "deletedBorneFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedBorneFilter", condition = "statut = :isDeleted")
public class Borne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    


    @Column(name = "libelle", nullable = true)
    private String libelle;

<<<<<<< HEAD
    @ManyToOne(targetEntity = PointArret.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_point_arret_fk")
=======
    

    @Column(name = "id_point_arret_fk", nullable = false)
>>>>>>> 841de88 (Update de l'API borne)
    private Integer idPointArretFk;

    

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

   
    public Integer getId() {
        return this.id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getIdPointArretFk() {
        return this.idPointArretFk;
    }

    public void setIdPointArretFk(Integer idPointArretFk) {
        this.idPointArretFk = idPointArretFk;
    }
    public Boolean getStatut() {
        return this.statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

}