package Low_Level_Design.Abstraction;

/*
Car Interface --> Act as an interface for outside world to operate the car.
This interface tells 'WHAT' all it can do rather than 'HOW' it does that.
Since this is an interface we cannot directly create Objects of this (before Java-8). We
need to implement it first and then that child class will have the responsibility to
provide implementation details of all the methods in the interface.

In our real world example of Car, imagine you sitting in the car and able to operate
the car (startEngine, accelerate, brake, turn) just by pressing or moving some
pedals/buttons/steering wheel etc. You don't need to know how these things work, and
also they are hidden under the hood.
This Interface 'Car' denotes that (pedals/buttons/steering wheel etc).
*/
public interface Car {
    void startEngine();
    void shiftGear(int gear);
    void accelerate();
    void brake();
    void stopEngine();
}

// “Interfaces in Java allow us to hide complex implementation details behind a simple contract.
// This promotes abstraction and makes the system more modular, testable, and extensible.”