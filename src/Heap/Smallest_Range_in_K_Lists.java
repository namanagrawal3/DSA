package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Smallest_Range_in_K_Lists {
    static class Pair {
        int row;
        int col;
        int val;
        public Pair(int r, int c, int v) {
            row = r;
            col = c;
            val = v;
        }
    }
    public static void main(String[] args) {
        int n = 5, k = 3;
        int arr[][] = {{4, 7, 9, 12, 15}, {0, 8, 10, 14, 20}, {6, 12, 16, 30, 50}};

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.val - b.val;
            }
        });

        int range = Integer.MAX_VALUE;
        int leftVal = -1;
        int rightVal = -1;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(i, 0, arr[i][0]));
            maxValue = Math.max(maxValue, arr[i][0]);
        }

        while (true) {                  // Size of priorityqueue 'pq' will be maintained to 'k' always
            Pair rv = pq.poll();
            int minValue = rv.val;
            if (maxValue - minValue < range) {
                leftVal = minValue;
                rightVal = maxValue;
                range = maxValue - minValue;
            }

            if (rv.col + 1 < n) {
                pq.add(new Pair(rv.row, rv.col+1, arr[rv.row][rv.col+1]));
                maxValue = Math.max(maxValue, arr[rv.row][rv.col+1]);
            }
            else
                break;
        }

        System.out.println(leftVal + " " + rightVal);
    }
}
