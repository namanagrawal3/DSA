package Dynamic_Programming;

import java.util.Arrays;

public class Valentine_Magic {
    public static void main(String[] args) {
        int[] boys = {2, 11, 3};
        int[] girls = {5, 7, 3, 2};

        Arrays.sort(boys);
        Arrays.sort(girls);

        int[][] dp = new int[boys.length][girls.length];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        System.out.println(pairTD(boys, girls, 0, 0, dp));
    }
    public static int pairTD(int[] boys, int[] girls, int i, int j, int[][] dp) {
        if (i == boys.length)
            return 0;
        if (j == girls.length)
            return 100000000;

        if (dp[i][j] != -1)
            return dp[i][j];

        int pair = 0, not_pair = 0;
        pair = Math.abs(boys[i] - girls[j]) + pairTD(boys, girls, i+1, j+1, dp);
        not_pair = pairTD(boys, girls, i, j+1, dp);

        return dp[i][j] = Math.min(pair, not_pair);
    }
}
