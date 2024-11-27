package Graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Prims_Algorithm {
    private HashMap<Integer, HashMap<Integer, Integer>> map;
    public Prims_Algorithm(int vertices) {
        this.map = new HashMap<>();
        for (int i = 1; i <= vertices; i++) {
            map.put(i, new HashMap<>());
        }
    }
    public void addEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }
    class PrimsPair {
        int vtx;
        int acq_vtx;
        int cost;
        public PrimsPair(int vtx, int acq_vtx, int cost) {
            this.vtx = vtx;
            this.acq_vtx = acq_vtx;
            this.cost = cost;
        }
        @Override
        public String toString() {
            return this.vtx + " " + this.acq_vtx + " @ " + this.cost;
        }
    }
    public int prims() {
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<PrimsPair> pq = new PriorityQueue<>(new Comparator<PrimsPair>() {
            @Override
            public int compare(PrimsPair o1, PrimsPair o2) {
                return o1.cost - o2.cost;
            }
        });

        pq.add(new PrimsPair(3, 3, 0));
        int ans = 0;

        while (!pq.isEmpty()) {
            PrimsPair rv = pq.poll();
            if (visited.contains(rv.vtx))
                continue;

            visited.add(rv.vtx);
            ans += rv.cost;
            System.out.println(rv);
            for (int nbrs : map.get(rv.vtx).keySet()) {
                if (!visited.contains(nbrs))
                    pq.add(new PrimsPair(nbrs, rv.vtx, map.get(rv.vtx).get(nbrs)));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Prims_Algorithm pa = new Prims_Algorithm(7);

        pa.addEdge(1, 2, 3);
        pa.addEdge(1, 4, 4);
        pa.addEdge(2, 3, 5);
        pa.addEdge(3, 4, 6);
        pa.addEdge(4, 5, 8);
        pa.addEdge(5, 6, 2);
        pa.addEdge(5, 7, 1);
        pa.addEdge(6, 7, 9);

        System.out.println(pa.prims());
    }
}
