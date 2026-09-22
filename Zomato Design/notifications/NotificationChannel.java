package notifications;
import models.User;
import models.Restaurant;
public interface NotificationChannel {
    void send(String message, User user);
    void send(String message, Restaurant restaurant);
}
