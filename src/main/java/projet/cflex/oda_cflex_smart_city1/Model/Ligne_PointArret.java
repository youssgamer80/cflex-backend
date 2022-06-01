package projet.cflex.oda_cflex_smart_city1.Model;


public class Ligne_PointArret {
    private Integer id_ligne;
    private int[] points ;

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
