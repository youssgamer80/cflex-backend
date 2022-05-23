package projet.cflex.oda_cflex_smart_city1.Model;
import lombok.*;
import java.io.Serializable;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "zone")

//@SQLDelete(sql = "UPDATE Zone SET statut = false WHERE id=?")
//@Where(clause = "statut=true")
public class Zone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "libelle", nullable = false)
    private String libelle;


    @ManyToOne(targetEntity = TypeZone.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_type_zone_fk", insertable = false, updatable = false, nullable = false)
    private TypeZone typezone;

    @Column(name = "id_type_zone_fk", nullable = false)
    private Integer idTypeZoneFk;


    @ManyToOne(targetEntity = Zone.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "zoneparent", insertable = false, updatable = false)
    private Zone zoneparent;


    @Column(name = "zoneparent", nullable = false)
    private Integer id_zoneparent;



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

    public TypeZone getTypezone() {
        return this.typezone;
    }

    public void setTypezone(TypeZone typezone) {
        this.typezone = typezone;
    }

    public Integer getIdTypeZoneFk() {
        return this.idTypeZoneFk;
    }

    public void setIdTypeZoneFk(Integer idTypeZoneFk) {
        this.idTypeZoneFk = idTypeZoneFk;
    }

    public Zone getZoneparent() {
        return this.zoneparent;
    }

    public void setZoneparent(Zone zoneparent) {
        this.zoneparent = zoneparent;
    }

    public Integer getId_zoneparent() {
        return this.id_zoneparent;
    }

    public void setId_zoneparent(Integer id_zoneparent) {
        this.id_zoneparent = id_zoneparent;
    }

    public Boolean isStatut() {
        return this.statut;
    }

    public Boolean getStatut() {
        return this.statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

}