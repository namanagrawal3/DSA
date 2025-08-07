package Design_Patterns.With_Strategy_Pattern;

public class Vehicle {
    DriveStrategy driveObj;

    // This is known as "Constructor Injection"
    Vehicle(DriveStrategy obj) {
        this.driveObj = obj;
    }

    public void drive() {
        driveObj.drive();
    }

}
