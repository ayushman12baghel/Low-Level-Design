package orders;
import models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderGroup {
    private int id;
    private User user;
    private List<Order> orders;

    public OrderGroup(int id, User user) {
        this.id = id; this.user = user; this.orders = new ArrayList<>();
    }
    public void addOrder(Order order) { orders.add(order); }
    
    public Order getOrderById(int orderId) {
        Optional<Order> orderOpt = orders.stream().filter(o -> o.getId() == orderId).findFirst();
        return orderOpt.orElse(null);
    }
    
    public double getTotal() {
        return orders.stream().mapToDouble(Order::calculateTotal).sum();
    }
    public List<Order> getOrders() { return orders; }
}
