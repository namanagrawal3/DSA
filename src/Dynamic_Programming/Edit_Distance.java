package Dynamic_Programming;

import java.util.Arrays;

public class Edit_Distance {
    public static void main(String[] args) {
        String s = "FOOD";
        String t = "MONEY";

        int[][] dp = new int[s.length()][t.length()];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(disTD(s, t, 0, 0, dp));

        System.out.println(disBU(s, t));
    }
    public static int disTD(String s, String t, int i, int j, int[][] dp) {
        if (i == s.length())
            return t.length() - j;
        if (j == t.length())
            return s.length() - i;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = 0;
        if (s.charAt(i) == t.charAt(j))
            ans = disTD(s, t, i+1, j+1, dp);
        else {
            int delete = disTD(s, t, i+1, j, dp);
            int replace = disTD(s, t, i+1, j+1, dp);
            int insert = disTD(s, t, i, j+1, dp);
            ans = 1 + Math.min(delete, Math.min(replace, insert));
        }

        return dp[i][j] = ans;
    }
    public static int disBU(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];

        for (int row = 1; row < dp.length; row++) {
            dp[row][0] = row;
        }
        for (int col = 1; col < dp[0].length; col++) {
            dp[0][col] = col;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];
                    int insert = dp[i][j-1];
                    dp[i][j] = Math.min(delete, Math.min(replace, insert)) + 1;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
