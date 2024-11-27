package Dynamic_Programming;
import java.util.*;

public class Binary_Knapsack {
    public static void main(String[] args) {
        int cap = 4;
        int[] wt = {1, 2, 3, 2, 2};
        int[] val = {8, 4, 0, 5, 3};
        int n = wt.length;

        int[][] dp = new int[cap+1][n];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(knapsackTD(wt, val, cap, 0, dp));

        System.out.println(knapsackBU(wt, val, cap));
    }
    public static int knapsackTD(int[] wt, int[] val, int cap, int idx, int[][] dp) {
        if (idx == wt.length || cap == 0)
            return 0;

        if (dp[cap][idx] != -1)
            return dp[cap][idx];

        int take = 0, not_take = 0;
        if (cap >= wt[idx])
            take = val[idx] + knapsackTD(wt, val, cap-wt[idx], idx+1, dp);
        not_take = knapsackTD(wt, val, cap, idx+1, dp);

        return dp[cap][idx] = Math.max(take, not_take);
    }
    public static int knapsackBU(int[] wt, int[] val, int cap) {
        int[][] dp = new int[wt.length+1][cap+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int take = 0, not_take = 0;
                if (j >= wt[i-1])
                    take = val[i-1] + dp[i-1][j-wt[i-1]];
                not_take = dp[i-1][j];

                dp[i][j] = Math.max(take, not_take);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
