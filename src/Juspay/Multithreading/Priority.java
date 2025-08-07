package Juspay.Multithreading;

public class Priority extends Thread {
    public Priority(String name) {          // customizing the thread-name
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " with Priority: " + Thread.currentThread().getPriority() + " is running");
        }
    }

    public static void main(String[] args) {
        Priority t1 = new Priority("Low-Priority Thread");
        Priority t2 = new Priority("Medium-Priority Thread");
        Priority t3 = new Priority("High-Priority Thread");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }
}
