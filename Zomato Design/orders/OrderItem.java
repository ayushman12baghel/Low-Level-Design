package orders;
import models.MenuItem;
public class OrderItem {
    private MenuItem menuItem;
    private int quantity;
    private double price;
    public OrderItem(MenuItem menuItem, int quantity, double price) {
        this.menuItem = menuItem; this.quantity = quantity; this.price = price;
    }
    public double getTotalPrice() { return price * quantity; }
}
