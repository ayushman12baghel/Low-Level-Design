package models;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Restaurant {
    private int id;
    private String name;
    private String description;
    private Address address;
    private double rating;
    private List<MenuItem> menu;

    public Restaurant(int id, String name, String description, Address address, double rating) {
        this.id = id; this.name = name; this.description = description; 
        this.address = address; this.rating = rating; this.menu = new ArrayList<>();
    }
    
    public void addMenuItem(MenuItem item) { menu.add(item); }
    public void removeMenuItem(MenuItem item) { menu.remove(item); }
    
    public void updateMenuItem(MenuItem updatedItem) {
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getId() == updatedItem.getId()) {
                menu.set(i, updatedItem);
                return;
            }
        }
    }
    
    public MenuItem getMenuItem(int id) {
        Optional<MenuItem> itemOpt = menu.stream().filter(m -> m.getId() == id).findFirst();
        return itemOpt.orElse(null);
    }
    
    public List<MenuItem> getMenu() { return menu; }
    public String getName() { return name; }
    public int getId() { return id; }
}
