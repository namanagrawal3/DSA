package Graph;

import java.util.*;

public class Graph_Valid_Tree {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};

        System.out.println(isValidTree(n, edges));
    }
    public static boolean isValidTree(int n, int[][] edges) {

        // graph having no cycle and having only 1 component is a tree

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int component = 0;

        for (int key : map.keySet()) {
            if (visited.contains(key))
                continue;

            component++;

            q.add(key);
            while (!q.isEmpty()) {
                int rv = q.poll();
                if (visited.contains(rv))                           // means graph contains a cycle
                    return false;
                visited.add(rv);
                for (int nbrs : map.get(rv)) {
                    if (!visited.contains(nbrs))
                        q.add(nbrs);
                }
            }
        }
        return component == 1;
    }
}
