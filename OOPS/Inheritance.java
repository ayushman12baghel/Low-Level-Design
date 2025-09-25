import java.util.*;

class Car {
    protected String brand;
    protected String model;
    protected boolean isEngineOn = false;
    protected int currentSpeed = 0;
    protected int currentGear = 0;

    private String tyreCompany;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public int getSpeed() {
        return currentSpeed;
    }

    public String getTyreCompany() {
        return tyreCompany;
    }

    public void setTyreCompany(String tyreCompany) {
        this.tyreCompany = tyreCompany;
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine Started!");
    }

    public void shiftGear(int gear) {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off cant shift gear!");
            return;
        }

        currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }

    public void accelerate() {
        if (!isEngineOn) {
            System.out.println(brand + " " + model + " : Engine is off cant accelerate!");
            return;
        }

        currentSpeed += 20;
        System.out.println(brand + " " + model + " : accelerated to " + currentSpeed);
    }

    public void brake() {
        currentSpeed -= 20;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }

        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }

    public void stopEngine() {
        isEngineOn = false;
        currentGear = 0;
        currentSpeed = 0;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }
}

class ManualCar extends Car {
    private int currentGear;

    public ManualCar(String brand, String model) {
        super(brand, model);
        this.currentGear = 0;
    }

    public void shiftGear(int gear) {
        currentGear = gear;

        System.out.println("Gear shifted to " + currentGear);
    }
}

class ElectricCar extends Car {
    private int batteryPercent;

    public ElectricCar(String brand, String model) {
        super(brand, model);
        this.batteryPercent = 0;
    }

    public void chargeBattery() {
        batteryPercent = 100;

        System.out.println(brand + " " + model + " : Battery fully charged");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        ManualCar myManualCar = new ManualCar("Suzuki", "WagonR");
        myManualCar.startEngine();
        myManualCar.shiftGear(1); // Specific to Manual Car
        myManualCar.accelerate();
        myManualCar.brake();
        myManualCar.stopEngine();

        System.out.println("----------------------");

        ElectricCar myElectricCar = new ElectricCar("Tesla", "Model S");
        myElectricCar.chargeBattery(); // Specific to Electric Car
        myElectricCar.startEngine();
        myElectricCar.accelerate();
        myElectricCar.brake();
        myElectricCar.stopEngine();
    }
}