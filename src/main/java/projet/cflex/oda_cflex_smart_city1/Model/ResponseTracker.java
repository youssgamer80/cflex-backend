package projet.cflex.oda_cflex_smart_city1.Model;

import java.util.ArrayList;
import java.util.List;

public class ResponseTracker {
    
    private Channel channel;
    private List<feed> feeds = new ArrayList<feed>();
    public Channel getChannel() {
        return channel;
    }
    public void setChannel(Channel channel) {
        this.channel = channel;
    }
    public List<feed> getFeeds() {
        return feeds;
    }
    public void setFeeds(List<feed> feeds) {
        this.feeds = feeds;
    }
    public class Channel {
        private Integer id;
        private String name;
        private String description;
        private String latitude;
        private String longitude;
        private String field1;
        private String field2;
        private String field3;
        private String field4;
        private String field5;
        private String createdAt;
        private String updatedAt;
        private Integer lastEntryId;
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String getLatitude() {
            return latitude;
        }
        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }
        public String getLongitude() {
            return longitude;
        }
        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }
        public String getField1() {
            return field1;
        }
        public void setField1(String field1) {
            this.field1 = field1;
        }
        public String getField2() {
            return field2;
        }
        public void setField2(String field2) {
            this.field2 = field2;
        }
        public String getField3() {
            return field3;
        }
        public void setField3(String field3) {
            this.field3 = field3;
        }
        public String getField4() {
            return field4;
        }
        public void setField4(String field4) {
            this.field4 = field4;
        }
        public String getField5() {
            return field5;
        }
        public void setField5(String field5) {
            this.field5 = field5;
        }
        public String getCreatedAt() {
            return createdAt;
        }
        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }
        public String getUpdatedAt() {
            return updatedAt;
        }
        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
        public Integer getLastEntryId() {
            return lastEntryId;
        }
        public void setLastEntryId(Integer lastEntryId) {
            this.lastEntryId = lastEntryId;
        }
    }
    public class feed {
        private String createdAt;
        private Integer entryId;
        public String field1;
        private String field2;
        private String field3;
        private String field4;
        private String field5;
        public String getCreatedAt() {
            return createdAt;
        }
        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }
        public Integer getEntryId() {
            return entryId;
        }
        public void setEntryId(Integer entryId) {
            this.entryId = entryId;
        }
        public String getField1() {
            return field1;
        }
        public void setField1(String field1) {
            this.field1 = field1;
        }
        public String getField2() {
            return field2;
        }
        public void setField2(String field2) {
            this.field2 = field2;
        }

        public void setField3(String field3){

            this.field3 = field3;
        }

        public String getField3(){
            return field3;
        }

        public void setField4(String field4) {
            this.field4 = field4;
        }
        public String getField4() {
            return field4;
        }
        public void setField5(String field5) {
            this.field5 = field5;
        }
        public String getField5() {
            return field5;
        }
    }
}
