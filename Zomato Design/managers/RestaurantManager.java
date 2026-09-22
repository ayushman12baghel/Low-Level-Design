package managers;
import models.Restaurant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantManager {
    private Map<Integer, Restaurant> restaurants = new HashMap<>();
    
    public void addRestaurant(Restaurant restaurant) { restaurants.put(restaurant.getId(), restaurant); }
    public Restaurant getRestaurant(int id) { return restaurants.get(id); }
    public void removeRestaurant(int id) { restaurants.remove(id); }
    public List<Restaurant> getAllRestaurants() { return new ArrayList<>(restaurants.values()); }
}
