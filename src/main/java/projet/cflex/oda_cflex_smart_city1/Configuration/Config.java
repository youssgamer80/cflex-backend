/*
package projet.cflex.oda_cflex_smart_city1.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableElasticsearchRepositories(basePackages = "projet.cflex.oda_cflex_smart_city1.repository")
@ComponentScan(basePackages = { "projet.cflex.oda_cflex_smart_city1.service" })
public class Config {
    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());

}
 }*/
