package notifications;
import models.User;
import models.Restaurant;
public class SMSNotification implements NotificationChannel {
    @Override
    public void send(String message, User user) { System.out.println("SMS to User " + user.getName() + ": " + message); }
    @Override
    public void send(String message, Restaurant restaurant) { System.out.println("SMS to Restaurant " + restaurant.getName() + ": " + message); }
}
