package notifications;
import models.User;
import models.Restaurant;
public class EmailNotification implements NotificationChannel {
    @Override
    public void send(String message, User user) { System.out.println("Email to User " + user.getName() + ": " + message); }
    @Override
    public void send(String message, Restaurant restaurant) { System.out.println("Email to Restaurant " + restaurant.getName() + ": " + message); }
}
