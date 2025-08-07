package Juspay.Synchronization;

public class MyThread extends Thread{
    private Counter counter;
    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        MyThread t1 = new MyThread(counter);        // common object is passed (ie, common resource is shared among multiple threads)
        MyThread t2 = new MyThread(counter);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {}

        System.out.println(counter.getCount());

        // Thus, getting unexpected result due to 'Race-Condition' which occured due to concurrent execution of multiple threads
        // which can be avoided using the 'synchronized' keyword or block in the critical-section part of the program
        // which ensures the 'Mutual-Exclusion' ,ie, only one thread can access the critical-section at a time



    }
}
