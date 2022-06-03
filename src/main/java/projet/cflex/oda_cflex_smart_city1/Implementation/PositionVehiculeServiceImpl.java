/*
package projet.cflex.oda_cflex_smart_city1.Implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.cflex.oda_cflex_smart_city1.Model.PositionVehicule;
//import projet.cflex.oda_cflex_smart_city1.Repository.PositionVehiculeRepository;
import projet.cflex.oda_cflex_smart_city1.Service.PositionVehiculeService;
import projet.cflex.oda_cflex_smart_city1.exception.PositionVehiculeException;

import javax.validation.ConstraintViolationException;
import java.util.*;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PositionVehiculeServiceImpl implements PositionVehiculeService {
    @Autowired
    private PositionVehiculeRepository positionVehiculeRepository;

    @Override
    public PositionVehicule create(PositionVehicule positionVehicule) {
        log.info("Enregistrement d'un nouveau vehicule: {}","Title:"+" "+positionVehicule.getTitle()+"/n"+
                "Id_tracker:"+" "+positionVehicule.getIdTracker());
        return positionVehiculeRepository.save(positionVehicule);
    }

    @Override
    public Collection<PositionVehicule> list(boolean isDeleted) {
        return null;
    }

    @Override
    public PositionVehicule get(Long id) {
        return null;
    }

    @Override
    public void createTracker(PositionVehicule positionVehicule)throws ConstraintViolationException, PositionVehiculeException{
        Optional<PositionVehicule> positionVehiculeOptional = positionVehiculeRepository.findPositionVehiculeBy(positionVehicule.getTitle());
        positionVehiculeRepository.save(positionVehicule);
       */
/* if (positionVehiculeOptional.isPresent()){
            throw new PositionVehiculeException(PositionVehiculeException.TrackerAlreadyExists());
        }else{

        }*//*

    }
    @Override
    public void run(){
        TimerTask timerTask = new MaTache();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 2000);
        System.out.println("Lancement execution");
        while (true)
            timer.purge();
    }


}
*/
