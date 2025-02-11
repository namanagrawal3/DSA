package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite_Graph {
    static class Pair {
        int val;
        int dist;
        public Pair(int val, int dist) {
            this.val = val;
            this.dist = dist;
        }
    }
    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};                    // Jagged Array
        System.out.println(isBipartite(graph));
    }
    public static boolean isBipartite(int[][] graph) {
        // acyclic graph is always bipartite in nature
        // even length cyclic graph is also bipartite
        // but odd length cyclic graph is never bipartite

        HashMap<Integer, Integer> visited = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();

        for (int src = 0; src < graph.length; src++) {
            if (visited.containsKey(src))
                continue;

            q.add(new Pair(src, 0));
            while (!q.isEmpty()) {
                Pair rv = q.poll();
                if (visited.containsKey(rv.val)) {
                    if (visited.get(rv.val) != rv.dist)                 // means odd length cycle is present
                        return false;
                    continue;
                }

                visited.put(rv.val, rv.dist);

                for (int nbrs : graph[rv.val]) {
                    if (!visited.containsKey(nbrs))
                        q.add(new Pair(nbrs, rv.dist + 1));
                }
            }
        }
        return true;
    }
}
