package cart;
import models.Restaurant;
import models.MenuItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantCart {
    private Restaurant restaurant;
    private List<CartItem> items;

    public RestaurantCart(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.items = new ArrayList<>();
    }
    public Restaurant getRestaurant() { return restaurant; }
    public List<CartItem> getItems() { return items; }
    
    public void addItem(MenuItem item, int qty) {
        Optional<CartItem> existingItem = items.stream().filter(ci -> ci.getMenuItem().getId() == item.getId()).findFirst();
        if (existingItem.isPresent()) {
            existingItem.get().increaseQuantity(qty);
        } else {
            items.add(new CartItem(item, qty));
        }
    }
    public void removeItem(MenuItem item) {
        items.removeIf(ci -> ci.getMenuItem().getId() == item.getId());
    }
    public void updateQuantity(MenuItem item, int qty) {
        if (qty <= 0) {
            removeItem(item);
            return;
        }
        for (CartItem ci : items) {
            if (ci.getMenuItem().getId() == item.getId()) {
                ci.increaseQuantity(qty - ci.getQuantity()); // set to exactly qty
                return;
            }
        }
    }
    public double getTotal() {
        return items.stream().mapToDouble(CartItem::getSubtotal).sum();
    }
}
