package Low_Level_Design.Polymorphism.Static_Dynamic_Polymorphism;

public class StaticDynamicPolymorphism {
    public static void main(String[] args) {
        Car myManualCar = new ManualCar("Suzuki", "WagonR");
        myManualCar.startEngine();
        myManualCar.accelerate();
        myManualCar.accelerate(30);
        myManualCar.brake();
        myManualCar.stopEngine();

        System.out.println("----------------------");

        Car myElectricCar = new ElectricCar("Tesla", "Model S");
        myElectricCar.startEngine();
        myElectricCar.accelerate();
        myElectricCar.accelerate(40);
        myElectricCar.brake();
        myElectricCar.stopEngine();
    }
}
