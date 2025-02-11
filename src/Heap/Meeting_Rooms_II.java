package Heap;

import java.util.*;

public class Meeting_Rooms_II {
    static class Pair {
        int st;
        int ed;
        public Pair(int s, int e) {
            st = s;
            ed = e;
        }
    }
    public static void main(String[] args) {
        int[] start = {2, 9, 6};
        int[] end = {4, 12, 10};

        int n = start.length;
        List<Pair> ll = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ll.add(new Pair(start[i], end[i]));
        }

        Collections.sort(ll, new Comparator<Pair>() {
            @Override                               // sort on the basis of 'start time'
            public int compare(Pair a, Pair b) {
                return a.st - b.st;
            }
        });

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override                               // sort on the basis of 'end time'
            public int compare(Pair a, Pair b) {
                return a.ed - b.ed;
            }
        });

        int minRooms = 0;
        for (int i = 0; i < n; i++) {
            if (!pq.isEmpty()) {
                if (ll.get(i).st >= pq.peek().ed)
                    pq.poll();
            }

            pq.add(ll.get(i));
            minRooms = Math.max(minRooms, pq.size());
        }

        System.out.println(minRooms);
    }
}
