package projet.cflex.oda_cflex_smart_city1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.custom.repository.support.CustomRepositoryFactoryBean;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication


//@EnableJpaRepositories(repositoryFactoryBeanClass= CustomRepositoryFactoryBean.class)
@OpenAPIDefinition(info =
	@Info(title = "C'Flex API", version = "${project.version}", description = "Documentation de l'API de C'Flex v1.0")
)

public class OdaCflexSmartCity1Application {

  @Autowired

    public static void main(String[] args) {

        SpringApplication.run(OdaCflexSmartCity1Application.class, args);

    }


}