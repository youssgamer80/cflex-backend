package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;

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
@Table(name = "zone")

public class Zone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "libelle", nullable = false)
    private String libelle;


    @ManyToOne(targetEntity = TypeZone.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_zone_fk")
    private TypeZone idTypeZoneFk;


    @ManyToOne(targetEntity = Zoneparent.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_zoneparent_fk")
    private Zoneparent idZoneparentFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = Boolean.TRUE;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public TypeZone getIdTypeZoneFk() {
        return this.idTypeZoneFk;
    }

    public void setIdTypeZoneFk(TypeZone idTypeZoneFk) {
        this.idTypeZoneFk = idTypeZoneFk;
    }

    public Zoneparent getIdZoneparentFk() {
        return this.idZoneparentFk;
    }

    public void setIdZoneparentFK(Zoneparent idZoneparentFk) {
        this.idZoneparentFk = idZoneparentFk;
    }


    public Boolean getStatut() {
        return this.statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

}