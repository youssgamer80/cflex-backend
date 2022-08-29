package projet.cflex.oda_cflex_smart_city1.Model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
 
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(indexName="pa")
public class PointArretSocketModel {

    @Id
    private String id;
    private String nom_point_arret;
    private String latitude;
    private String longitude;
    private String nombre_place_disponible_couloir;
    private String vehicule_disponibles;
    ArrayList < Vehicule > vehicule_en_approche = new ArrayList < Vehicule > ();
   
    public PointArretSocketModel(String id, String nom_point_arret,String latitude, String longitude, String nombre_place_disponible_couloir, String vehicule_disponibles){
        
    }
   }
