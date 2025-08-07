package Juspay;

import java.util.ArrayDeque;
import java.util.Queue;

public class Largest_Sum_Cycle {
    public static void main(String[] args) {
        int[] edge = {4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 11, -1, 10, 15, 22, 22, 22, 22, 22, 21};
//        int[] edge = {2, 0, -1, 2};

        int n = edge.length;
        int[] inDeg = new int[n];                  // Nodes which are not added in Queue, will form cycles (Topological Sort)
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            int u = i;
            int v = edge[i];
            if (v == -1)
                continue;

            inDeg[v]++;
        }
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int rv = q.poll();
            visited[rv] = true;

            int v = edge[rv];
            if (v == -1)
                continue;
            inDeg[v]--;
            if (inDeg[v] == 0)
                q.add(v);
        }

        int maxCycle = -1;
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;

            int sum = i;
            int nbr = edge[i];
            while (i != nbr) {
                sum += nbr;
                visited[nbr] = true;
                nbr = edge[nbr];
            }
            maxCycle = Math.max(maxCycle, sum);
        }

        if (maxCycle == -1)
            System.out.println("Cycle doesn't exist");
        System.out.println(maxCycle);
    }
}
