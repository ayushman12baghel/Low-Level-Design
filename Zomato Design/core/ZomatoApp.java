package core;

import managers.UserManager;
import managers.RestaurantManager;
import managers.OrderManager;
import notifications.NotificationService;

public class ZomatoApp {
    private static ZomatoApp instance;
    private UserManager userManager;
    private RestaurantManager restaurantManager;
    private OrderManager orderManager;
    private NotificationService notificationService;

    private ZomatoApp() {
        userManager = new UserManager();
        restaurantManager = new RestaurantManager();
        orderManager = new OrderManager();
        notificationService = new NotificationService();
    }

    public static ZomatoApp getInstance() {
        if (instance == null) {
            instance = new ZomatoApp();
        }
        return instance;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public RestaurantManager getRestaurantManager() {
        return restaurantManager;
    }

    public OrderManager getOrderManager() {
        return orderManager;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }
}
