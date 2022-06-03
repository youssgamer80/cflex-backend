package projet.cflex.oda_cflex_smart_city1.Implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projet.cflex.oda_cflex_smart_city1.Controller.PositionVehiculeController;
import projet.cflex.oda_cflex_smart_city1.Model.PositionVehicule;
import projet.cflex.oda_cflex_smart_city1.Repository.PositionVehiculeRepository;
import projet.cflex.oda_cflex_smart_city1.Service.PositionVehiculeService;

import java.util.Timer;
import java.util.TimerTask;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PositionVehiculeServiceImpl implements PositionVehiculeService {
/*    @Autowired
    PositionVehiculeController positionVehiculeController;*/
    @Autowired
    private PositionVehiculeRepository positionVehiculeRepository;

    @Override
    public PositionVehicule create(PositionVehicule positionVehicule) {
        log.info("Enregistrement d'un nouveau vehicule: {}","Title:"+" "+positionVehicule.getTitle()+"/n"+
                "Id_tracker:"+" "+positionVehicule.getIdTracker());
        return positionVehiculeRepository.save(positionVehicule);
    }

    @Override

    public void run(PositionVehicule positionVehicule) {
        //positionVehiculeController.setPositiontracker(positionVehicule);
        TimerTask timerTask = new MaTache();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 2000);
        System.out.println("Lancement execution");
        while (true)
            timer.purge();
     /*   try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        timer.cancel();*/
    }



}
