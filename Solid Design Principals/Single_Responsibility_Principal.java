import java.util.*;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class ShoppingCartViolated {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotal() {
        double total = 0;

        for (Product p : products) {
            total += p.price;
        }

        return total;
    }

    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : products) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + calculateTotal());
    }

    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}

// Optimal Approach ->

class ShoppingCartFollowed {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotal() {
        double total = 0;

        for (Product p : products) {
            total += p.price;
        }

        return total;
    }
}

class ShoppingCartPrinter {
    private ShoppingCartFollowed cart;

    public ShoppingCartPrinter(ShoppingCartFollowed cart) {
        this.cart = cart;
    }

    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (Product p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotal());
    }
}

class ShoppingCartStorage {
    private ShoppingCartFollowed cart;

    public ShoppingCartStorage(ShoppingCartFollowed cart) {
        this.cart = cart;
    }

    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}

public class Single_Responsibility_Principal {
    public static void main(String[] args) {
        ShoppingCartViolated cart = new ShoppingCartViolated();

        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 2000));

        cart.printInvoice();
        cart.saveToDatabase();

        System.out.println("-------------------------------------------------------------");

        ShoppingCartFollowed cart2 = new ShoppingCartFollowed();

        cart2.addProduct(new Product("Laptop", 50000));
        cart2.addProduct(new Product("Mouse", 2000));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart2);
        printer.printInvoice();

        ShoppingCartStorage db = new ShoppingCartStorage(cart2);
        db.saveToDatabase();
    }

}
