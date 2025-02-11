package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Topological_Sort_Kahn_Algorithm {
    public static void main(String[] args) {
        int[][] adj = {{2,3}, {4}, {1,3}, {1}, {}, {1,4}};

        int v = adj.length;
        int[] inDeg = new int[v];
        for (int[] e : adj) {
            for (int u : e) {
                inDeg[u]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();          // we put only those vertices in Queue which have inDegree '0'
        int cnt = 0;
        for (int i = 0; i < v; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int rv = q.poll();
            System.out.print(rv + " ");
            cnt++;

            for (int nbr : adj[rv]) {
                inDeg[nbr]--;
                if (inDeg[nbr] == 0)
                    q.add(nbr);
            }
        }

        System.out.println();
        System.out.println(cnt);

        // It is also used to detect a cycle in a 'Directed Graph'
        // if 'cnt' is not equal to the 'v' then cycle exists in a graph
    }
}
