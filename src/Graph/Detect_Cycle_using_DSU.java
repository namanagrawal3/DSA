package Graph;

import java.util.*;
public class Detect_Cycle_using_DSU {
    static int[] parent;
    static int[] rank;
    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();                             //  [[2,3,4],[3],[0,4],[0,1],[0,2]]

        parent = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        Arrays.fill(rank, 0);

        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                if (u < v) {
                    int parent_u = findParent(u);
                    int parent_v = findParent(v);

                    if (parent_u == parent_v) {
                        System.out.println("Cycle exists");
                        return;
                    }
                    else
                        union(parent_u, parent_v);
                }
            }
        }
        System.out.println("Cycle doesn't exist");;
    }
    public static int findParent(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = findParent(parent[x]);
    }
    public static void union(int x, int y) {
        int parent_x = findParent(x);
        int parent_y = findParent(y);

        if (parent_x == parent_y)
            return;

        if (rank[parent_x] > rank[parent_y])
            parent[parent_y] = parent_x;
        else if (rank[parent_x] < rank[parent_y])
            parent[parent_x] = parent_y;
        else {
            parent[parent_y] = parent_x;
            rank[parent_x]++;
        }
    }
}
