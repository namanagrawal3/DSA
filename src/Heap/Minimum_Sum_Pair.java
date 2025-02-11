package Heap;

import java.util.PriorityQueue;

public class Minimum_Sum_Pair {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1};
        int n = arr.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();      // min-Heap
        for (int a : arr) {
            pq.add(a);
        }

        int minSum = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            minSum += a+b;
            pq.add(a+b);
        }

        System.out.println(minSum);
    }
}
