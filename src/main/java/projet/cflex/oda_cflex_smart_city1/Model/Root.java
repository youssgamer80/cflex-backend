package projet.cflex.oda_cflex_smart_city1.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Root {
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
}
