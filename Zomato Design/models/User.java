package models;
import java.util.ArrayList;
import java.util.List;
import cart.CartItem;
import cart.RestaurantCart;
import cart.Cart;
import orders.OrderGroup;
import orders.Order;
import factories.OrderFactory;

public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private List<Address> addresses;
    private Cart cart;
    private List<OrderGroup> orderGroups;

    public User(int id, String name, String email, String phone) {
        this.id = id; this.name = name; this.email = email; this.phone = phone; 
        this.addresses = new ArrayList<>(); 
        this.cart = new Cart(id, this);
        this.orderGroups = new ArrayList<>();
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Cart getCart() { return cart; }
    
    public void addAddress(Address address) { addresses.add(address); }
    public void removeAddress(Address address) { addresses.remove(address); }
    public List<Address> getAddresses() { return addresses; }
    public List<OrderGroup> getOrderGroups() { return orderGroups; }
    
    public void addToCart(Restaurant restaurant, MenuItem item, int qty) {
        cart.addItem(restaurant, item, qty);
    }
    
    public void removeFromCart(Restaurant restaurant, MenuItem item) {
        cart.removeItem(restaurant, item);
    }
    
    public OrderGroup placeOrder(OrderFactory factory, Address deliveryAddress) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Cannot place order.");
            return null;
        }

        OrderGroup orderGroup = new OrderGroup(orderGroups.size() + 1, this);
        
        for (RestaurantCart rc : cart.getRestaurantCarts()) {
            Order order = factory.createOrder(this, rc.getRestaurant(), rc.getItems(), deliveryAddress);
            orderGroup.addOrder(order);
        }
        
        cart.clearCart();
        orderGroups.add(orderGroup);
        return orderGroup;
    }
}
