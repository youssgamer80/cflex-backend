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
@Table(name = "zoneparent")


public class Zoneparent {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "zoneparent", nullable = false)
    private String zoneparent;

    @Column(name = "statut", nullable = false)
    private Boolean statut = Boolean.TRUE;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZoneparent() {
        return this.zoneparent;
    }

    public void setZoneparent(String zoneparent) {
        this.zoneparent = zoneparent;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public Boolean getStatut(){
        return statut;
    }

}