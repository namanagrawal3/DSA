package Graph;
import java.util.*;

public class Shortest_Path_in_Weighted_Undirected_graph {
    static class Pair {
        int dist;
        int node;
        public Pair(int d, int nn) {
            dist = d;
            node = nn;
        }
    }
    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1}, {4,3,3}, {3,5,1}};

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            map.put(i, new HashMap<>());
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            map.get(u).put(v, w);
            map.get(v).put(u, w);
        }

        // vertices --> 1 to n,   edges --> {a,b,w} (a to b with weight w)
        // shortest path from vertex 1 to n (src -> 1, des -> n)

        int[] ans = new int[n+1];               // stores the shortest distance of each node from source
        int[] parent = new int[n+1];            // stores the parent of each node via the shortest path

        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.dist - b.dist;
            }
        });

        ans[1] = 0;
        pq.add(new Pair(0,1));

        while (!pq.isEmpty()) {
            Pair rv = pq.poll();
            int d = rv.dist;
            int node = rv.node;

            for (int adjNode : map.get(node).keySet()) {
                int dist = map.get(node).get(adjNode);
                if (d + dist < ans[adjNode]) {
                    ans[adjNode] = d + dist;
                    pq.add(new Pair(d+dist, adjNode));

                    parent[adjNode] = node;
                }
            }
        }

        if (ans[n] == Integer.MAX_VALUE) {              // path does not exist
            System.out.println(-1);
            return;
        }

        List<Integer> path = new ArrayList<>();
        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);

        System.out.println(ans[n] + " " + path);
    }
}
