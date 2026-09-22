package orders;
import models.User;
import models.Restaurant;
import models.Address;
import payments.Payment;
import java.util.List;

public class Order {
    private int id;
    private User user;
    private Restaurant restaurant;
    private List<OrderItem> items;
    private Address address;
    private OrderStatus status;
    private Payment payment;

    public Order(int id, User user, Restaurant restaurant, List<OrderItem> items, Address address) {
        this.id = id; this.user = user; this.restaurant = restaurant; this.items = items; this.address = address; this.status = OrderStatus.PLACED;
    }
    public int getId() { return id; }
    public double calculateTotal() {
        return items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
    }
    public void updateStatus(OrderStatus status) {
        this.status = status;
        System.out.println("Order " + id + " status updated to " + status);
    }
    public void setPayment(Payment payment) { this.payment = payment; }
    public User getUser() { return user; }
    public Restaurant getRestaurant() { return restaurant; }
    public OrderStatus getStatus() { return status; }
}
