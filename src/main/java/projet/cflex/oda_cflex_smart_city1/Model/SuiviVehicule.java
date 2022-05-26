package projet.cflex.oda_cflex_smart_city1.Model;


import javax.persistence.Id;
import java.lang.annotation.Documented;

public class SuiviVehicule {
    @Id
    private Integer id;
    private Double position;
    private Vehicule levehicule;
    private Trackergps letrackergps;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPosition() {
        return position;
    }

    public void setPosition(Double position) {
        this.position = position;
    }

    public Vehicule getLevehicule() {
        return levehicule;
    }

    public void setLevehicule(Vehicule levehicule) {
        this.levehicule = levehicule;
    }

    public Trackergps getLetrackergps() {
        return letrackergps;
    }

    public void setLetrackergps(Trackergps letrackergps) {
        this.letrackergps = letrackergps;
    }
}
