package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;

@Entity
@Table(name = "type_transport")
public class TypeTransport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "libelle_type_transport")
    private String libelleTypeTransport;

    @Column(name = "statut")
    private Boolean statut;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelleTypeTransport() {
        return libelleTypeTransport;
    }

    public void setLibelleTypeTransport(String libelleTypeTransport) {
        this.libelleTypeTransport = libelleTypeTransport;
    }
    

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }
}