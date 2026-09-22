package models;
public class MenuItem {
    private int id;
    private String name;
    private String description;
    private double price;
    private String category;
    private boolean isVegetarian;
    private boolean isAvailable;

    public MenuItem(int id, String name, String description, double price, String category, boolean isVegetarian, boolean isAvailable) {
        this.id = id; this.name = name; this.description = description; 
        this.price = price; this.category = category; this.isVegetarian = isVegetarian; this.isAvailable = isAvailable;
    }
    public int getId() { return id; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getName() { return name; }
}
