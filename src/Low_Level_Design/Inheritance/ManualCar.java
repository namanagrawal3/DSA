package Low_Level_Design.Inheritance;

public class ManualCar extends Car {            // Inherits from Car
    // specific character of Manual-Car
    private int currentGear;

    public ManualCar(String brand, String model) {
        super(brand, model);
        this.currentGear = 0;
    }

    // specific behaviour of Manual-Car
    public void shiftGear(int gear) {
        this.currentGear = gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }
}
