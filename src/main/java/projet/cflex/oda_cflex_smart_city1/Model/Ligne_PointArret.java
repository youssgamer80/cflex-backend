package projet.cflex.oda_cflex_smart_city1.Model;


public class Ligne_PointArret {

    public Ligne_PointArret(Integer id_ligne, int[] points) {
        this.id_ligne = id_ligne;
        this.points = points;
    }
    private Integer id_ligne;
    private int[] points ;
    private Boolean sens;

    public Boolean isSens() {
        return this.sens;
    }

    public Boolean getSens() {
        return this.sens;
    }

    public void setSens(Boolean sens) {
        this.sens = sens;
    }

    public int[] getPoints() {
        return this.points;
    }
    public int getPoints(int i) {
        return this.points[i];
    }

    public void setPoints(int[] points) {
        this.points = points;
    }

    public Integer getId_ligne() {
        return this.id_ligne;
    }

    public void setId_ligne(Integer id_ligne) {
        this.id_ligne = id_ligne;

        }
    
}
