package factories;
import models.User;
import models.Restaurant;
import models.Address;
import cart.CartItem;
import orders.Order;
import java.util.List;

public interface OrderFactory {
    Order createOrder(User user, Restaurant restaurant, List<CartItem> items, Address address);
}
