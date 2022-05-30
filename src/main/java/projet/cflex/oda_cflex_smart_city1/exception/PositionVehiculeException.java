package projet.cflex.oda_cflex_smart_city1.exception;

public class PositionVehiculeException extends Throwable {
    private static final long tracker = 1L;

   public static String NotFoundException(Long id){
       return ("Le tracker "+id+"n'existe pas");
   }

   public static String TrackerAlreadyExists(){
       return ("Ce tracker existe déjà");
   }
}
