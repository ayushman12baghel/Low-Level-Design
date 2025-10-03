import java.util.*;

class NoSingleTon {
    public NoSingleTon() {
        System.out.println("NoSingleton object intialised");
    }
}

class SimpleSingleton {
    private static SimpleSingleton instance = null;

    private SimpleSingleton() {
        System.out.println("Simple Singleton initialised");
    }

    public static SimpleSingleton getInstance() {
        if (instance == null) {
            instance = new SimpleSingleton();
        }

        return instance;
    }
}

public class Simple_Singleton {
    public static void main(String[] args) {
        NoSingleTon ns1 = new NoSingleTon();
        NoSingleTon ns2 = new NoSingleTon();

        System.out.println(ns1 == ns2);

        SimpleSingleton ss1 = SimpleSingleton.getInstance();
        SimpleSingleton ss2 = SimpleSingleton.getInstance();

        System.out.println(ss1 == ss2);
    }
}