package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;

@Entity
@Table(name = "zone")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_type_zone_fk", nullable = false)
    private TypeZone idTypeZoneFk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zoneparent")
    private Zone zoneparent;

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

    public TypeZone getIdTypeZoneFk() {
        return idTypeZoneFk;
    }

    public void setIdTypeZoneFk(TypeZone idTypeZoneFk) {
        this.idTypeZoneFk = idTypeZoneFk;
    }

    public Zone getZoneparent() {
        return zoneparent;
    }

    public void setZoneparent(Zone zoneparent) {
        this.zoneparent = zoneparent;
    }

}