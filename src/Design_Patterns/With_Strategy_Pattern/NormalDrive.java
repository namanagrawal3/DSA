package Design_Patterns.With_Strategy_Pattern;

public class NormalDrive implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Normal drive capability");
    }
}
