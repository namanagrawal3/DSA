package Low_Level_Design.Encapsulation;

public class Encapsulation {
    public static void main(String[] args) {
        SportsCar mySportsCar = new SportsCar("Ford", "Mustang");

        mySportsCar.startEngine();
        mySportsCar.shiftGear(1);
        mySportsCar.accelerate();
        mySportsCar.shiftGear(2);
        mySportsCar.accelerate();
        mySportsCar.brake();
        mySportsCar.stopEngine();

        // Here, we are able to set arbitrary value to speed

        // mySportsCar.currentSpeed = 500;
        // System.out.println("Current Speed of My Sports Car is set to " + mySportsCar.currentSpeed);

        System.out.println("Current Speed of My Sports Car is " + mySportsCar.getSpeed());
    }
}
