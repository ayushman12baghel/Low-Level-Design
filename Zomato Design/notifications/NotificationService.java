package notifications;
import models.User;
import models.Restaurant;
import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private List<NotificationChannel> observers = new ArrayList<>();
    
    public void addChannel(NotificationChannel channel) { observers.add(channel); }
    public void removeChannel(NotificationChannel channel) { observers.remove(channel); }
    
    public void notifyUser(User user, String message) {
        for (NotificationChannel channel : observers) { channel.send(message, user); }
    }
    public void notifyRestaurant(Restaurant restaurant, String message) {
        for (NotificationChannel channel : observers) { channel.send(message, restaurant); }
    }
}
