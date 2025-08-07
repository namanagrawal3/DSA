package Juspay.Multithreading;

public class Types extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello World");
        }
    }

    public static void main(String[] args) {
//        Types userThread = new Types();
//        userThread.start();
//        System.out.println("Main Done!!");


        Types daemonThread = new Types();
        daemonThread.setDaemon(true);
        daemonThread.start();
        System.out.println("Main Done!!");
    }
}
