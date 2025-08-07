package Juspay.Synchronization;

public class DeadLock {
    public static void main(String[] args) {
        final String resource1 = "Laptop";      // 'final' ensures resource reference can’t be changed by any thread
        final String resource2 = "Mobile";

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1: locked Laptop");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {}

                    synchronized (resource2) {
                        System.out.println("Thread 1: locked Mobile");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2: locked Mobile");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {}

                    synchronized (resource1) {
                        System.out.println("Thread 2: locked Laptop");
                    }
                }
            }
        });

        t1.start();
        t2.start();

        // Both threads (t1 & t2) are waiting for each other to release the lock — this causes "Deadlock"
    }
}
