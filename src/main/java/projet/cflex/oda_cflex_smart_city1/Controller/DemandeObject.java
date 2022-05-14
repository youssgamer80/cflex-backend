package projet.cflex.oda_cflex_smart_city1.Controller;


import java.time.Instant;

public class DemandeObject {
    private int id;
    private String codeDemande = CodeDemandeGenerator.generateRandomCodeDemande(10,48,122);
    private Boolean etat;
    private Instant date;
    private Boolean status = Boolean.FALSE;
    private int proprietaireId;

    private int typeTransportId;

    private int zoneId;


    public int getId() {
        return id;
    }

    public int getTypeTransportId() {
        return typeTransportId;
    }

    public void setTypeTransportId(int typeTransportId) {
        this.typeTransportId = typeTransportId;
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeDemande() {
        return codeDemande;
    }

    public void setCodeDemande(String codeDemande) {
        this.codeDemande = codeDemande;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getProprietaireId() {
        return proprietaireId;
    }

    public void setProprietaireId(int proprietaireId) {
        this.proprietaireId = proprietaireId;
    }
}
