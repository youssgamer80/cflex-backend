package projet.cflex.oda_cflex_smart_city1.Model;

import javax.persistence.*;

@Entity
@Table(name = "mode_deplacement")
public class ModeDeplacement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "mode_deplacement")
    private String modeDeplacement;

    @Column(name = "statut")
    private Boolean statut;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModeDeplacement() {
        return modeDeplacement;
    }

    public void setModeDeplacement(String modeDeplacement) {
        this.modeDeplacement = modeDeplacement;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

}