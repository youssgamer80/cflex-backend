package projet.cflex.oda_cflex_smart_city1.Implementation;
import java.util.Date;
import java.util.TimerTask;

public class MaTache extends TimerTask {
    @Override
    public void run() {
        System.out.println("Envoie de la position " + new Date());
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Fin " + new Date());
    }
}