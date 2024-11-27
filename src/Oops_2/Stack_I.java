package Oops_2;

public interface Stack_I {
    int x = 10;                      // variables are public static final (byDefault)
    public void push(int item);      // methods are public abstract (byDefault)
    public int pop();
    public int peek();
    public static void fun1() {

    }
    public default void fun2() {

    }
}
