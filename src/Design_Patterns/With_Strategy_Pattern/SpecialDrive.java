package Design_Patterns.With_Strategy_Pattern;

public class SpecialDrive implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Special drive capability");
    }
}
