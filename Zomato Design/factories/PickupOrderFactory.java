package factories;
import models.User;
import models.Restaurant;
import models.Address;
import cart.CartItem;
import orders.Order;
import orders.OrderItem;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;

public class PickupOrderFactory implements OrderFactory {
    @Override
    public Order createOrder(User user, Restaurant restaurant, List<CartItem> items, Address address) {
        // Pickup orders don't need a delivery address
        List<OrderItem> orderItems = items.stream().map(ci -> new OrderItem(ci.getMenuItem(), ci.getQuantity(), ci.getMenuItem().getPrice())).collect(Collectors.toList());
        int orderId = new Random().nextInt(10000);
        return new Order(orderId, user, restaurant, orderItems, null);
    }
}
