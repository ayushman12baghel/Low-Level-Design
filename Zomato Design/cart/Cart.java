package cart;
import models.User;
import models.Restaurant;
import models.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int id;
    private User user;
    private List<RestaurantCart> restaurantCarts;

    public Cart(int id, User user) {
        this.id = id; this.user = user; this.restaurantCarts = new ArrayList<>();
    }
    public void addItem(Restaurant restaurant, MenuItem item, int qty) {
        RestaurantCart rc = getRestaurantCart(restaurant);
        if (rc == null) {
            rc = new RestaurantCart(restaurant);
            restaurantCarts.add(rc);
        }
        rc.addItem(item, qty);
    }
    public void removeItem(Restaurant restaurant, MenuItem item) {
        RestaurantCart rc = getRestaurantCart(restaurant);
        if (rc != null) {
            rc.removeItem(item);
            if (rc.getItems().isEmpty()) {
                restaurantCarts.remove(rc);
            }
        }
    }
    public void updateQuantity(Restaurant restaurant, MenuItem item, int newQty) {
        RestaurantCart rc = getRestaurantCart(restaurant);
        if (rc != null) {
            rc.updateQuantity(item, newQty);
            if (rc.getItems().isEmpty()) {
                restaurantCarts.remove(rc);
            }
        }
    }
    
    private RestaurantCart getRestaurantCart(Restaurant restaurant) {
        return restaurantCarts.stream().filter(c -> c.getRestaurant().getId() == restaurant.getId()).findFirst().orElse(null);
    }
    
    public void clearCart() { restaurantCarts.clear(); }
    public boolean isEmpty() { return restaurantCarts.isEmpty(); }
    public double getTotal() { return restaurantCarts.stream().mapToDouble(RestaurantCart::getTotal).sum(); }
    public List<RestaurantCart> getRestaurantCarts() { return restaurantCarts; }
}
