package Low_Level_Design.Inheritance;

public class ElectricCar extends Car {          // Inherits from Car
    // spcific character of Electric-Car
    private int batteryLevel;

    public ElectricCar(String brand, String model) {
        super(brand, model);
        this.batteryLevel = 100;
    }

    // specific behaviour of Electric-Car
    public void chargeBattery() {
        batteryLevel = 100;
        System.out.println(brand + " " + model + " : Battery fully charged!");
    }
}
