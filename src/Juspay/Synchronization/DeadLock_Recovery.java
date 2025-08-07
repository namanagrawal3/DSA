package Juspay.Synchronization;

public class DeadLock_Recovery {
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
                synchronized (resource1) {
                    System.out.println("Thread 2: locked Laptop");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {}

                    synchronized (resource2) {
                        System.out.println("Thread 2: locked Mobile");
                    }
                }
            }
        });

        t1.start();
        t2.start();

        // Both threads lock the resources in same order — Laptop first, then Mobile. So, no circular wait happens.
        // This is called "Lock-Ordering" — one of the best ways to avoid deadlocks.
    }
}
