package projet.cflex.oda_cflex_smart_city1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.data.custom.repository.support.CustomRepositoryFactoryBean;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import projet.cflex.oda_cflex_smart_city1.Repository.PositionRepository;

@SpringBootApplication
@EnableMongoRepositories

//@EnableJpaRepositories(repositoryFactoryBeanClass= CustomRepositoryFactoryBean.class)
@OpenAPIDefinition(info =
	@Info(title = "C'Flex API", version = "${project.version}", description = "Documentation de l'API de C'Flex v1.0")
)

public class OdaCflexSmartCity1Application implements CommandLineRunner{

  @Autowired
    PositionRepository positionRepo;
    public static void main(String[] args) {

        SpringApplication.run(OdaCflexSmartCity1Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
      // TODO Auto-generated method stub
      
    }

}