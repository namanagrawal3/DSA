package Low_Level_Design.Polymorphism.Static_Polymorphism;

public class StaticPolymorphism {
    public static void main(String[] args) {
        ManualCar myManualCar = new ManualCar("Suzuki", "WagonR");
        myManualCar.startEngine();
        myManualCar.accelerate();
        myManualCar.accelerate(40);
        myManualCar.brake();
        myManualCar.stopEngine();
    }
}
