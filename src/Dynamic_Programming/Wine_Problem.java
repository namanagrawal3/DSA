package Dynamic_Programming;

import java.util.Arrays;

public class Wine_Problem {
    public static void main(String[] args) {
        int[] pro = {2,3,5,1,4};

        int[][] dp = new int[pro.length][pro.length];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(wineTD(pro, 0, pro.length-1, 1, dp));               // Future DP

        System.out.println(wineBU(pro));
    }
    public static int wineTD(int[] pro, int si, int ei, int year, int[][] dp) {
        if (si > ei)
            return 0;

        if (dp[si][ei] != -1)
            return dp[si][ei];

        int first = pro[si]*year + wineTD(pro, si+1, ei, year+1, dp);
        int last = pro[ei]*year + wineTD(pro, si, ei-1, year+1, dp);

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
