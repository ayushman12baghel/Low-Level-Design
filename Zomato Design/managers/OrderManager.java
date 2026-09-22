package managers;
import models.User;
import orders.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderManager {
    private Map<Integer, Order> orders = new HashMap<>();
    
    public void createOrder(Order order) { orders.put(order.getId(), order); }
    public Order getOrder(int id) { return orders.get(id); }
    public void updateOrder(Order order) { orders.put(order.getId(), order); } // In memory, just re-put or it modifies in place
    public void removeOrder(int id) { orders.remove(id); }
    public List<Order> getAllOrders() { return new ArrayList<>(orders.values()); }
    
    public List<Order> getOrdersByUser(User user) {
        return getOrdersByUserId(user.getId());
    }
    
    public List<Order> getOrdersByUserId(int userId) {
        return orders.values().stream()
                .filter(o -> o.getUser().getId() == userId)
                .collect(Collectors.toList());
    }
}
