package Oops_3;

public class A_Class implements A {

    @Override
    public void funA() {

    }

    @Override
    public int pay() {
        return 0;
    }

    @Override
    public void funB() {

    }

    @Override
    public void funC() {

    }

    @Override
    public void display() {        // only one-time

    }

    public static void main(String[] args) {
        A_Class a = new A_Class();
        a.display();                                // way to achieve "Multiple-Inheritance"
    }
}
