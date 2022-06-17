package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Model.TronconTypeTransport;
import projet.cflex.oda_cflex_smart_city1.Repository.TronconTypeTransportRepository;

@Service
public class TronconTypeTransportService {
    @Autowired
    private final TronconTypeTransportRepository repository;

    public TronconTypeTransportService(TronconTypeTransportRepository repository) {
        this.repository = repository;
    }

    public List<TronconTypeTransport> List(Integer idTroncon){

        List<TronconTypeTransport> result = new ArrayList<>();
        repository.findByIdTronconFkNative(idTroncon).forEach(result::add);
        return result;

    }
    
}
