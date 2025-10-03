import java.util.*;

interface Burger {
    void prepare();
}

class BasicBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger");
    }
}

class StandardBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger");
    }
}

class PremiumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Premium Burger");
    }
}

class BurgerFactory {
    public Burger creatBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurger();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}

public class SimpleFactory {
    public static void main(String args[]) {
        String type = "standard";

        BurgerFactory myBurgerFactory = new BurgerFactory();
        Burger burger = myBurgerFactory.creatBurger(type);

        if (burger != null) {
            burger.prepare();
        }
    }
}