package cart;
import models.MenuItem;
public class CartItem {
    private MenuItem menuItem;
    private int quantity;
    public CartItem(MenuItem menuItem, int quantity) { this.menuItem = menuItem; this.quantity = quantity; }
    
    public void increaseQuantity(int qty) { this.quantity += qty; }
    public void decreaseQuantity(int qty) { 
        this.quantity -= qty; 
        if (this.quantity < 0) this.quantity = 0;
    }
    
    public double getSubtotal() { return menuItem.getPrice() * quantity; }
    public MenuItem getMenuItem() { return menuItem; }
    public int getQuantity() { return quantity; }
}
