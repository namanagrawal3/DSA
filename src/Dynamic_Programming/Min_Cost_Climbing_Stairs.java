package Dynamic_Programming;

import java.util.Arrays;

public class Min_Cost_Climbing_Stairs {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        int[] dp = new int[cost.length];

        Arrays.fill(dp, -1);
        int idx_0 = costTD(cost, 0, dp);
        Arrays.fill(dp, -1);
        int idx_1 = costTD(cost, 1, dp);

        System.out.println(Math.min(idx_0, idx_1));

        System.out.println(costBU(cost));
    }
    public static int costTD(int[] cost, int idx, int[] dp) {
        if (idx >= cost.length)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int oneStep = costTD(cost, idx+1, dp);
        int twoSteps = costTD(cost, idx+2, dp);

        return dp[idx] = Math.min(oneStep, twoSteps) + cost[idx];
    }
    public static int costBU(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            int oneStep = dp[i-1];
            int twoSteps = dp[i-2];
            dp[i] = Math.min(oneStep, twoSteps) + cost[i];
        }

        return Math.min(dp[n-1], dp[n-2]);
    }
}
