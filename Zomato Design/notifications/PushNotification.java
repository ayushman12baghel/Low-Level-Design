package notifications;
import models.User;
import models.Restaurant;
public class PushNotification implements NotificationChannel {
    @Override
    public void send(String message, User user) { System.out.println("Push to User " + user.getName() + ": " + message); }
    @Override
    public void send(String message, Restaurant restaurant) { System.out.println("Push to Restaurant " + restaurant.getName() + ": " + message); }
}
