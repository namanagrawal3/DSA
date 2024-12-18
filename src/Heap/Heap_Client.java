package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap_Client {
    public static void main(String[] args) {
        Heap_Implement hp = new Heap_Implement();
        hp.add(10);
        hp.add(20);
        hp.add(30);
        hp.add(5);
        hp.add(7);
        hp.add(3);
        hp.add(-2);

        System.out.println(hp.get());
        hp.display();
        hp.remove();
        System.out.println(hp.get());
        hp.display();

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();                                  // min-Heap (byDefault)
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());        // max-Heap
    }
}
