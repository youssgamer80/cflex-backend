package projet.cflex.oda_cflex_smart_city1.Controller;


public class ZoneObjet {

    private Integer id;
    private String libelle;
    private Integer idTypeZoneFk;
    private Integer id_zoneparent;
    private Boolean statut;

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

    public Integer getIdTypeZoneFk() {
        return this.idTypeZoneFk;
    }

    public void setIdTypeZoneFk(Integer idTypeZoneFk) {
        this.idTypeZoneFk = idTypeZoneFk;
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
