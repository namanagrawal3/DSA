package Heap;

import java.util.*;

public class Smallest_Range_Covering_Elements_from_K_Lists {
    static class Tuple{
        int val;
        int row;
        int col;
        public Tuple(int v, int r, int c) {
            val = v;
            row = r;
            col = c;
        }
    }
    public static void main(String[] args) {

        // nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
        List<List<Integer>> nums = new ArrayList<>();
        int k = nums.size();

        PriorityQueue<Tuple> pq = new PriorityQueue<>(new Comparator<Tuple>() {   // min-Heap
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o1.val - o2.val;
            }
        });

        int min = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {                       // push first item of each list into priority-queue
            pq.add(new Tuple(nums.get(i).get(0), i, 0));
            end = Math.max(end, nums.get(i).get(0));
            min = Math.min(min, nums.get(i).get(0));
        }
        int max = end;

        while (pq.size() == k) {
            Tuple rv = pq.poll();
            int start = rv.val;

            if (max - min > end - start) {
                min = start;
                max = end;
            }

            if (rv.col+1 < nums.get(rv.row).size()) {
                end = Math.max(end, nums.get(rv.row).get(rv.col+1));
                pq.add(new Tuple(nums.get(rv.row).get(rv.col+1), rv.row, rv.col+1));
            }
        }

        System.out.println(min + " " + max);
    }
}
