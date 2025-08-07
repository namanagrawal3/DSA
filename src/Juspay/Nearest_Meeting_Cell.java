package Juspay;

import java.util.*;
public class Nearest_Meeting_Cell {
    public static void main(String[] args) {
//        int[] edge = {4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 11, -1, 10, 15, 22, 22, 22, 22, 22, 21};
//        int c1 = 9, c2 = 2;

        int[] edge = {1, 2, 3, 4, 5, -1};           // Leetcode : 2359
        int c1 = 0, c2 = 4;

        int n = edge.length;
        boolean[] visited = new boolean[n];             // MultiSource BFS
        Queue<Integer> q = new ArrayDeque<>();

        q.add(c1);
        q.add(c2);
        while (!q.isEmpty()) {
            int rv = q.poll();
            if (visited[rv]) {
                System.out.println(rv);
                return;
            }

            visited[rv] = true;
            int nbr = edge[rv];
            if (nbr == -1)
                continue;

            q.add(nbr);
        }

        System.out.println(-1);
    }
}
