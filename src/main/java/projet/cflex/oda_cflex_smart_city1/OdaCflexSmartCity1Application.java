package projet.cflex.oda_cflex_smart_city1;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
//@EnableJpaRepositories(repositoryFactoryBeanClass= CustomRepositoryFactoryBean.class)
@OpenAPIDefinition(info =
	@Info(title = "C'Flex API", version = "${project.version}", description = "Documentation de l'API de C'Flex v1.0")
)

public class OdaCflexSmartCity1Application {

  @Value("${spring.data.mongodb.uri}")
  private String connectionString;

  @Bean("MyBean")
  public MongoClient mongoClient() {
    CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
    CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
    return MongoClients.create(MongoClientSettings.builder()
        .applyConnectionString(new ConnectionString(connectionString))
        .codecRegistry(codecRegistry)
        .build());
  }
  public static void main(String[] args) {

    SpringApplication.run(OdaCflexSmartCity1Application.class, args);

  }
    
}