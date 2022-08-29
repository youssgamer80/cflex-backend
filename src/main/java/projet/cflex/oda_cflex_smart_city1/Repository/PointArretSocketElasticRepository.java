package projet.cflex.oda_cflex_smart_city1.Repository;
 
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import projet.cflex.oda_cflex_smart_city1.Model.PointArretSocketModel;
 
public interface PointArretSocketElasticRepository extends ElasticsearchRepository<PointArretSocketModel, String> {
 
}
