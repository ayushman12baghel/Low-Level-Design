import core.ZomatoApp;
import models.*;
import cart.*;
import orders.*;
import factories.*;
import payments.*;
import notifications.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Starting Zomato Application ---");
        ZomatoApp app = ZomatoApp.getInstance();

        // 1. Setup Notifications
        NotificationService notifier = app.getNotificationService();
        notifier.addChannel(new SMSNotification());
        notifier.addChannel(new PushNotification());

        // 2. Setup Data using Managers
        User user = new User(1, "Ayush", "ayush@example.com", "9999999999");
        Address home = new Address(1, "123 Main St", "City", "State", "110001", AddressType.HOME);
        user.addAddress(home);
        app.getUserManager().addUser(user); // using proper addUser

        Restaurant restaurantA = new Restaurant(1, "Pizza Hut", "Best Pizzas", new Address(2, "Mall Rd", "City", "State", "110002", AddressType.WORK), 4.5);
        MenuItem pizza = new MenuItem(1, "Margherita", "Cheese Pizza", 299.0, "Italian", true, true);
        restaurantA.addMenuItem(pizza);
        app.getRestaurantManager().addRestaurant(restaurantA);

        Restaurant restaurantB = new Restaurant(2, "Burger King", "Best Burgers", new Address(3, "High St", "City", "State", "110003", AddressType.WORK), 4.2);
        MenuItem burger = new MenuItem(2, "Whopper", "Big Burger", 199.0, "American", false, true);
        restaurantB.addMenuItem(burger);
        app.getRestaurantManager().addRestaurant(restaurantB);

        // 3. User updates Cart with new Cart logic
        System.out.println("\n--- User Adds Items to Cart ---");
        user.addToCart(restaurantA, pizza, 1);
        user.addToCart(restaurantA, pizza, 1); // should increase quantity to 2
        user.addToCart(restaurantB, burger, 3);
        
        // Update quantity test
        user.getCart().updateQuantity(restaurantB, burger, 1); // reduce to 1
        System.out.println("Cart total: " + user.getCart().getTotal());

        // Simulate price hike to prove OrderItem preserves historical price
        pizza.setPrice(350.0);

        // 4. Place Order via User
        System.out.println("\n--- Placing Order ---");
        OrderFactory orderFactory = new DeliveryOrderFactory();
        OrderGroup orderGroup = user.placeOrder(orderFactory, user.getAddresses().get(0));
        System.out.println("Total Order Group Amount: " + orderGroup.getTotal());

        // 5. Processing Payment & Notifications
        System.out.println("\n--- Processing Payment & Notifications ---");
        for (Order order : orderGroup.getOrders()) {
            app.getOrderManager().createOrder(order); // Store globally

            // Demonstrate changing strategy dynamically
            PaymentStrategy strategy = new CardPayment(); 
            Payment payment = new Payment(order.getId(), order, order.calculateTotal(), strategy);
            
            payment.setPaymentStrategy(new UPIPayment());
            
            if (payment.makePayment()) {
                order.setPayment(payment);
                order.updateStatus(OrderStatus.CONFIRMED);
                
                notifier.notifyUser(order.getUser(), "Your order from " + order.getRestaurant().getName() + " is confirmed!");
                notifier.notifyRestaurant(order.getRestaurant(), "New order received for " + order.calculateTotal());
            }
        }
        
        // 6. Verify System Order Management vs User History
        System.out.println("\n--- Verifying Order Management ---");
        List<Order> userOrders = app.getOrderManager().getOrdersByUser(user);
        System.out.println("System OrderManager tracked " + userOrders.size() + " orders for Ayush.");
        for (Order o : userOrders) {
            System.out.println("System Order " + o.getId() + " - Total: " + o.calculateTotal() + " - Status: " + o.getStatus());
        }
        
        // Check historical price vs new menu price
        System.out.println("\n--- Verifying Historical Pricing ---");
        System.out.println("Current Pizza Hut Margherita Price: " + app.getRestaurantManager().getRestaurant(1).getMenuItem(1).getPrice());
        Order pizzaOrder = app.getOrderManager().getOrdersByUser(user).stream().filter(o -> o.getRestaurant().getId() == 1).findFirst().get();
        System.out.println("Price paid in past order (Order " + pizzaOrder.getId() + "): " + pizzaOrder.calculateTotal());
    }
}
