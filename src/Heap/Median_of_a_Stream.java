package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Median_of_a_Stream {
    public static void main(String[] args) {
        int arr[] = {5, 15, 1, 3, 2, 8};
        int n = arr.length;

        ArrayList<Double> ll = new ArrayList<>();
        PriorityQueue<Integer> leftMax = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightMin = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            ll.add(findMedian(arr[i], leftMax, rightMin));
        }

        System.out.println(ll);
    }
    public static double findMedian(int val, PriorityQueue<Integer> leftMax, PriorityQueue<Integer> rightMin) {
        // adding the element
        if (leftMax.isEmpty())
            leftMax.add(val);
        else {
            if (val < leftMax.peek())
                leftMax.add(val);
            else
                rightMin.add(val);
        }

        // balancing the queues
        if (rightMin.size() > leftMax.size())
            leftMax.add(rightMin.poll());
        else if (leftMax.size() - rightMin.size() > 1)
            rightMin.add(leftMax.poll());

        // finding the median
        if (leftMax.size() > rightMin.size())
            return (double) leftMax.peek();
        return (leftMax.peek() + rightMin.peek())/2.0;
    }
}
