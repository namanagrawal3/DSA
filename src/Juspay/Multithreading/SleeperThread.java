package Juspay.Multithreading;

public class SleeperThread {
    public static void main(String[] args) {
        Thread sleeper = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " is sleeping");
                    Thread.sleep(5000);
                    System.out.println("woke up!!");
                }
                catch (InterruptedException e) {
                    System.out.println("Forcefully awoked!!, sleep interrupted");
                }
            }
        });

        sleeper.start();

        try {
            System.out.println(Thread.currentThread().getName() + " is sleeping");
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        sleeper.interrupt();
    }
}
