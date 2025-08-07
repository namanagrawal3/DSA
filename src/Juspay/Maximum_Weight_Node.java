package Juspay;

public class Maximum_Weight_Node {
    public static void main(String[] args) {
        int[] edge = {4, 4, -1, 2, 2, 3, 4};
//        int[] edge = {4, 4, -1, 2, 2};
//        int[] edge = {4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 11, -1, 10, 15, 22, 22, 22, 22, 22, 21};

        int n = edge.length;
        int[] wt = new int[n];                          // Simple based on the concept of 'InDegree'

        for (int i = 0; i < n; i++) {
            int u = i;
            int v = edge[i];
            if (v == -1)
                continue;

            wt[v] += u;
        }

        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (wt[i] >= wt[maxIdx])
                maxIdx = i;
        }

        System.out.println(maxIdx);
    }
}
