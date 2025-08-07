package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Maximum_Sum_Combination {
    static class Pair {
        int sum;
        int idx;
        public Pair(int s, int i) {
            sum = s;
            idx = i;
        }
    }
    public static void main(String[] args) {
        int a[] = {1, 4, 2, 3}, b[] = {2, 5, 1, 6};
        int k = 3;

        int n = a.length;
        Arrays.sort(a);
        Arrays.sort(b);

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return b.sum - a.sum;
            }
        });

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(a[i] + b[n-1], n-1));
        }

        ArrayList<Integer> ll = new ArrayList<>();
        while (k-- > 0) {
            Pair rv = pq.poll();
            int sum = rv.sum;
            int idx = rv.idx;

            ll.add(sum);
            if (idx-1 >= 0)
                pq.add(new Pair(sum - b[idx] + b[idx-1], idx-1));
        }

        System.out.println(ll);
    }
}
