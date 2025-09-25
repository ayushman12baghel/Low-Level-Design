import java.util.*;

interface Car {
    void startEngine();

    void shiftGear(int gear);

    void accelerate();

    void brake();

    void stopEngine();
}

class SportsCar implements Car {
    String brand;
    String model;
    boolean isEngineOn = false;
    int currentSpeed = 0;
    int currentGear = 0;

    public SportsCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine Started!");
    }

    @Override
    public void shiftGear(int gear) {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off cant shift gear!");
            return;
        }

        currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }

    @Override
    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off cant accelerate!");
            return;
        }

        currentSpeed += 20;
        System.out.println(brand + " " + model + " : accelerated to " + currentSpeed);
    }

    @Override
    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }

        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }

    @Override
    public void stopEngine() {
        isEngineOn = false;
        currentGear = 0;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }
}

class Abstraction {
    public static void main(String[] args) {
        Car myCar = new SportsCar("Ford", "Mustand");// Use the interface (Car) when you want flexibility and don’t need
                                                     // class-specific features.

        // Use the class (SportsCar) when you need something unique to that
        // implementation (like nitroBoost() if SportsCar had it).

        myCar.startEngine();
        myCar.shiftGear(1);
        myCar.accelerate();
        myCar.shiftGear(2);
        myCar.accelerate();
        myCar.brake();
        myCar.stopEngine();
    }
}