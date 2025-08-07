package Graph;
import java.util.*;

public class  Bellman_Ford_Algorithm {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1,5}, {1,0,3}, {1,2,-1}, {2,0,1}};          // (0,1,5) --> 0 to 1 with weight 5
        int src = 2;

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 1; count <= n-1; count++) {     // after (n-1) iterations, no relaxation will occur (when no cycle exists)
            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                int wt = e[2];

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;              // relaxation
                }
            }
        }

        for (int[] e : edges) {                         // n-th iteration
            int u = e[0];
            int v = e[1];
            int wt = e[2];

            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                System.out.println("-ve weight cycle exists");
                return;
            }
        }

        System.out.println(Arrays.toString(dist));

        // This algorithm is also used to detect the presence of -ve weight cycle in a graph
        // If in the nth iteration, relaxation takes place then -ve weight cycle exists in the graph
    }
}
