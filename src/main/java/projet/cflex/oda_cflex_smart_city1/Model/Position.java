package projet.cflex.oda_cflex_smart_city1.Model;

import java.security.Timestamp;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("position")
public class Position {

        @Id
        private int id;

        private int user_id;
        private Timestamp date_create;
        private String user_type;
        private Double longitude;
        private Double latitude;
        
        public Position(int id, int user_id, Timestamp date_create, String user_type, Double longitude, Double latitude) {
        
            this.id = id;
            this.user_id = user_id;
            this.date_create = date_create;
            this.user_type = user_type;
            this.longitude = longitude;
            this.latitude = latitude;
        }

        public void setId(int id){

            this.id = id;
        }
        public int getId(int id){
            return id;
        }

        public void setUserId(int user_id){
            this.user_id = user_id;
        }
        public int getUserId(int user_id){
            return  user_id;
        }

        public void setDateCreate(Timestamp date_create){
            this.date_create = date_create;
        }
        public Timestamp getDateCreate(Timestamp date_create){
            return  date_create;
        }

        public void setUserType(String user_type){
            this.user_type = user_type;
        }
        public String getUserType(String user_type){
            return  user_type;
        }

        public void setLongitude(Double longitude){
            this.longitude = longitude;
        }
        public Double getLongitude(Double longitude){
            return  longitude;
        }

        public void setLatitude(Double latitude){
            this.latitude = latitude;
        }
        public Double getLatitude(Double latitude){
            return  latitude;
        }

}
