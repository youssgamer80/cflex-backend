package projet.cflex.oda_cflex_smart_city1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication

@OpenAPIDefinition(info = @Info(title = "C'Flex API", version = "${project.version}", description = "Documentation de l'API de C'Flex v1.0"))
public class OdaCflexSmartCity1Application {

  public static void main(String[] args) {
    SpringApplication.run(OdaCflexSmartCity1Application.class, args);
  }

}