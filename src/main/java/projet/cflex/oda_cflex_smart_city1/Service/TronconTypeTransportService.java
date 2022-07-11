package projet.cflex.oda_cflex_smart_city1.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.internal.util.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import projet.cflex.oda_cflex_smart_city1.Controller.TronconTypeTransportObject;
import projet.cflex.oda_cflex_smart_city1.Model.Troncon;
import projet.cflex.oda_cflex_smart_city1.Model.TronconTypeTransport;
import projet.cflex.oda_cflex_smart_city1.Model.TypeTransport;
import projet.cflex.oda_cflex_smart_city1.Repository.TronconRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.TronconTypeTransportRepository;
import projet.cflex.oda_cflex_smart_city1.Repository.TypeTransportRepository;


@Service
public class TronconTypeTransportService {



    @Autowired
    private TronconTypeTransportRepository tronconTypeTransportRepository;


    @Autowired
    private TronconRepository tronconRepository;

    @Autowired
    private TypeTransportRepository typeTransportRepository;


    public List<TronconTypeTransport> getAllTronconTypeTransports() {

        List<TronconTypeTransport> tronconTypeTransports = new ArrayList<>();

        tronconTypeTransportRepository.findByStatutJPQL().forEach(tronconTypeTransports::add);

        return tronconTypeTransports;
    }



    public TronconTypeTransport addTronconTypeTransport(TronconTypeTransportObject tronconTypeTransportObject) {


        System.out.print(tronconTypeTransportObject.prix);
        // TypeTransport typeTransport = typeTransportRepository.findTypeTransport(ligneObject.idTypeTransportFk);
        Troncon troncon = tronconRepository.findTroncon(tronconTypeTransportObject.idTronconFk);
        TypeTransport typeTransport = typeTransportRepository.findTypeTransport(tronconTypeTransportObject.idTypeTransportFk);

        System.out.print(troncon);
        System.out.print(typeTransport);
        
        TronconTypeTransport tronconTypeTransport = new TronconTypeTransport();

        tronconTypeTransport.setIdTronconFk(troncon);
        tronconTypeTransport.setIdTypeTransportFk(typeTransport);
        tronconTypeTransport.setPrix(tronconTypeTransportObject.prix);
       

   

        return tronconTypeTransportRepository.save(tronconTypeTransport);
    }

    

}
