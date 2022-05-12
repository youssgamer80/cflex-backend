package projet.cflex.oda_cflex_smart_city1.Model;

import projet.cflex.oda_cflex_smart_city1.Model.TypeTransport;
import projet.cflex.oda_cflex_smart_city1.Model.Zone;

import javax.persistence.*;

@Entity
@Table(name = "ligne")
public class Ligne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "depart", nullable = false)
    private String depart;

    @Column(name = "arrivee", nullable = false)
    private String arrivee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_type_transport_fk", nullable = false)
    private TypeTransport idTypeTransportFk;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_zone_fk", nullable = false)
    private Zone idZoneFk;

    @Column(name = "statut", nullable = false)
    private Boolean statut = false;

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

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrivee() {
        return arrivee;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public TypeTransport getIdTypeTransportFk() {
        return idTypeTransportFk;
    }

    public void setIdTypeTransportFk(TypeTransport idTypeTransportFk) {
        this.idTypeTransportFk = idTypeTransportFk;
    }

    public Zone getIdZoneFk() {
        return idZoneFk;
    }

    public void setIdZoneFk(Zone idZoneFk) {
        this.idZoneFk = idZoneFk;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

}