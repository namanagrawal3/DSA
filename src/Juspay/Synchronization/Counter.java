package Juspay.Synchronization;

public class Counter {
    private int count = 0;
    public void increment() {                   // Critical-Section (common resource/data is accessing here)
        count++;
    }

//    public synchronized void increment() {      // 'synchronized' keyword will ensure the 'Mutual-Exclusion'
//        count++;
//    }

//    public void increment() {
//        synchronized (this) {
//            count++;
//        }
//    }

    public int getCount() {
        return count;
    }
}
