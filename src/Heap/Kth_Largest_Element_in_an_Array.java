package Heap;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {
    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = arr.length;

        for (int i = 0; i < k; i++) {           // size of k is maintained in a heap
            pq.add(arr[i]);
        }
        for (int i = k; i < n; i++) {
            if (arr[i] > pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        System.out.println(pq.peek());          // Time Complexity: O(n * log(k))
    }
}
