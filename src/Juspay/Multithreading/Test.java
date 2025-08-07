package Juspay.Multithreading;

public class Test {
    public static void main(String[] args) {
//        System.out.println("Hello World");
//        System.out.println(Thread.currentThread().getName());


        //***** 1. creating thread (using extends Thread) *****
//        World t1 = new World();
//        t1.start();


        // ***** 2. creating thread (using implements Runnable) *****
        World w = new World();
        Thread t1 = new Thread(w);
        t1.start();

        for (; ;) {
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
}
