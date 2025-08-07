package Juspay.Multithreading;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" is Running");
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {}

    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();                               // NEW state
        System.out.println(t1.getState());
        System.out.println(Thread.currentThread().getState());      // 'main' thread is running (so, RUNNABLE state)

        t1.start();                                                 // RUNNABLE state
        System.out.println(t1.getState());

        Thread.sleep(1000);

        System.out.println(t1.getState());

        t1.join();                                                 // 'main' (current thread) waiting for t1-thread to die
        System.out.println(t1.getState());
    }
}
