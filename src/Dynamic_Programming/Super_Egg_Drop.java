package Dynamic_Programming;

import java.util.Arrays;

public class Super_Egg_Drop {
    public static void main(String[] args) {
        int k = 3, n = 14;                        // we have to calculate the trials in worst case (i.e, with certainity)
        int[][] dp = new int[k+1][n+1];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(trialFun1(k, n, dp));



        int[][] dp2 = new int[k+1][n+1];         // Egg Drop Problem (MCM with Binary Search)
        for (int[] r : dp2) {
            Arrays.fill(r, -1);
        }
        System.out.println(trialFun2(k, n, dp2));
    }
    public static int trialFun1(int eggs, int floors, int[][] dp) {
        if (floors == 0 || floors == 1)
            return floors;
        if (eggs == 1)
            return floors;

        if (dp[eggs][floors] != -1)
            return dp[eggs][floors];

        int minTrials = Integer.MAX_VALUE;
        for (int k = 1; k <= floors; k++) {
            int breaks = -1, not_break = -1;
            if (dp[eggs-1][k-1] != -1)
                breaks = dp[eggs-1][k-1];
            else {
                breaks = trialFun1(eggs-1, k-1, dp);
                dp[eggs-1][k-1] = breaks;
            }

            if (dp[eggs][floors-k] != -1)
                not_break = dp[eggs][floors-k];
            else {
                not_break = trialFun1(eggs, floors-k, dp);
                dp[eggs][floors-k] = not_break;
            }

            int trials = 1 + Math.max(breaks, not_break);
            minTrials = Math.min(minTrials, trials);
        }

        return dp[eggs][floors] = minTrials;
    }
    public static int trialFun2(int eggs, int floors, int[][] dp) {
        if (floors == 0 || floors == 1)
            return floors;
        if (eggs == 1)
            return floors;

        if (dp[eggs][floors] != -1)
            return dp[eggs][floors];

        int minTrials = Integer.MAX_VALUE;
        int si = 1, ei = floors;
        while (si <= ei) {
            int mid = si + (ei-si)/2;

            int breaks = trialFun1(eggs-1, mid-1, dp);          // going left (downwards)
            int not_break = trialFun1(eggs, floors-mid, dp);    // going right (topwards)
            int trials = 1 + Math.max(breaks, not_break);
            minTrials = Math.min(minTrials, trials);

            if (breaks < not_break)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return dp[eggs][floors] = minTrials;
    }
}
