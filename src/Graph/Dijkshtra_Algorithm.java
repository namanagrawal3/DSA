package Graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Dijkshtra_Algorithm {
    private HashMap<Integer, HashMap<Integer, Integer>> map;
    public Dijkshtra_Algorithm(int vertices) {
        this.map = new HashMap<>();
        for (int i = 1; i <= vertices; i++) {
            map.put(i, new HashMap<>());
        }
    }
    public void addEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }
    public class Tuple {
        int vtx;
        String path;
        int cost;
        public Tuple(int vertex, String path, int cost) {
            this.vtx = vertex;
            this.path = path;
            this.cost = cost;
        }
        @Override
        public String toString() {
            return this.vtx + " " + this.path + " @ " + this.cost;
        }
    }
    public void dijkshtra(int src) {
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<Tuple> pq = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o1.cost - o2.cost;
            }
        });

        pq.add(new Tuple(src, ""+src, 0));

        while (!pq.isEmpty()) {
            Tuple rv = pq.poll();
            if (visited.contains(rv.vtx))
                continue;
            visited.add(rv.vtx);
            System.out.println(rv);
            for (int nbrs : map.get(rv.vtx).keySet()) {
                if (!visited.contains(nbrs))
                    pq.add(new Tuple(nbrs, rv.path + nbrs, rv.cost + map.get(rv.vtx).get(nbrs)));
            }
        }
    }

    public static void main(String[] args) {
        Dijkshtra_Algorithm dj = new Dijkshtra_Algorithm(7);

        dj.addEdge(1,4,2);
        dj.addEdge(1,2,4);
        dj.addEdge(2,3,5);
        dj.addEdge(3,4,1);
        dj.addEdge(4,5,6);
        dj.addEdge(5,6,11);
        dj.addEdge(7,5,1);
        dj.addEdge(6,7,3);

        dj.dijkshtra(1);
    }
}
