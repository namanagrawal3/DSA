package Graph;

import java.util.*;
public class Kosaraju_Algorithm {
    public static void main(String[] args) {
        int[][] adj = {{2, 3}, {0}, {1}, {4}, {}};
        int n = adj.length;

        // Step:1 Topological Order (using DFS, not Kahn's Algorithm)
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i])
                dfsStack(adj, i, st, visited);
        }

        // step:2 Reverse all the edges
        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj2.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adj[i].length; j++) {
                adj2.get(adj[i][j]).add(i);
            }
        }

        // Step:3 Pop-out the elements and apply the DFS
        Arrays.fill(visited, false);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int cnt = 0;

        while (!st.isEmpty()) {
            int src = st.pop();
            if (visited[src])
                continue;

            cnt++;
            ArrayList<Integer> ll = new ArrayList<>();
            dfsFun(adj2, visited, src, ll);

            Collections.sort(ll);
            ans.add(ll);
        }

        Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0) - b.get(0);
            }
        });

        System.out.println(cnt);
        System.out.println(ans);
    }
    public static void dfsStack(int[][] adj, int u, Stack<Integer> st, boolean[] visited) {
        visited[u] = true;

        for (int v: adj[u]) {
            if (!visited[v])
                dfsStack(adj, v, st, visited);
        }

        st.push(u);
    }
    public static void dfsFun(List<List<Integer>> adj, boolean[] visited, int u, ArrayList<Integer> ll) {
        visited[u] = true;
        ll.add(u);

        for (int v: adj.get(u)) {
            if (!visited[v])
                dfsFun(adj, visited, v, ll);
        }
    }
}
