package Dynamic_Programming;

import java.util.Arrays;

public class Wine_Problem {
    public static void main(String[] args) {
        int[] profit = {2, 3, 5, 1, 4};

        int[][] dp = new int[profit.length][profit.length];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(wineTD(profit, profit.length, 0, profit.length-1, dp));      // Future DP

        System.out.println(wineBU(profit));
    }
    public static int wineTD(int[] profit, int n, int si, int ei, int[][] dp) {
        if (si > ei)
            return 0;
        if (dp[si][ei] != -1)
            return dp[si][ei];

        int year = n + 1 - (ei-si+1);
        int first = (profit[si] * year) + wineTD(profit, n, si+1, ei, dp);
        int last = (profit[ei] * year) + wineTD(profit, n, si, ei-1, dp);

        return dp[si][ei] = Math.max(first, last);
    }
    public static int wineBU(int[] pro) {
        int[][] dp = new int[pro.length][pro.length];
        int year = pro.length;

        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = year * pro[i];
        }

        year--;
        for (int gap = 1; gap < pro.length; gap++) {            // j-i = gap
            for (int j = gap; j < dp[0].length; j++) {
                int i = j - gap;
                int first = pro[i]*year + dp[i+1][j];
                int last = pro[j]*year + dp[i][j-1];

                dp[i][j] = Math.max(first, last);
            }
            year--;
        }

        return dp[0][dp[0].length-1];
    }
}
