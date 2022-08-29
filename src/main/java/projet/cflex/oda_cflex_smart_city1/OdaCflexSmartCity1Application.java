package projet.cflex.oda_cflex_smart_city1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import projet.cflex.oda_cflex_smart_city1.Model.PointArretSocketModel;
import projet.cflex.oda_cflex_smart_city1.Model.Vehicule;
import projet.cflex.oda_cflex_smart_city1.Model.VehiculeEnApproche;
//import projet.cflex.oda_cflex_smart_city1.Repository.PointArretSocketElasticRepository;
//import projet.cflex.oda_cflex_smart_city1.Repository.PointArretSocketMongoRepository;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
//@EnableJpaRepositories(repositoryFactoryBeanClass= CustomRepositoryFactoryBean.class)
@OpenAPIDefinition(info =
	@Info(title = "C'Flex API", version = "${project.version}", description = "Documentation de l'API de C'Flex v1.0")
)
public class OdaCflexSmartCity1Application {

  @Autowired
    /*private PointArretSocketMongoRepository pointArretSocketMongorepository;
 
    @Autowired
    private PointArretSocketElasticRepository pointArretSocketElasticrepository;*/

  public static void main(String[] args) {

    SpringApplication.run(OdaCflexSmartCity1Application.class, args);

  }
    /*public void run(String... args) throws Exception {
        // insert three articles into Mongo
        ArrayList<Vehicule> vehiculeapproches = new ArrayList <Vehicule>();
        pointArretSocketMongorepository.save(new PointArretSocketModel("1", "nom_point_arret1", "latitude","longitude","nombre_place_disponible_couloir","vehicule_disponibles"));
        // fetch all articles from Mongo
        System.out.println("Articles found in MongoDB with findAll():");
        System.out.println("-----------------------------------------");
        Iterable<PointArretSocketModel> pointArret = pointArretSocketMongorepository.findAll();
        pointArret.forEach(System.out::println);
        System.out.println();
 
        TimeUnit.SECONDS.sleep(5);
 
        // fetch all articles from Elastisearch
        System.out.println("PointArret found in Elasticsearch with findAll():");
        System.out.println("-----------------------------------------------");
        pointArret = pointArretSocketElasticrepository.findAll();
        pointArret.forEach(System.out::println);
        System.out.println();
    }*/
}