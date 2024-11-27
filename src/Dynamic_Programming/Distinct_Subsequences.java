package Dynamic_Programming;

import java.awt.*;
import java.util.Arrays;

public class Distinct_Subsequences {
    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";

        int[][] dp = new int[s.length()][t.length()];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(subseqTD(s, t, 0, 0, dp));

        System.out.println(subseqBU(s, t));
    }
    public static int subseqTD(String s, String t, int i, int j, int[][] dp) {
        if (j == t.length())
            return 1;
        if (i == s.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int inc = 0, exc = 0;
        if (s.charAt(i) == t.charAt(j))
            inc = subseqTD(s, t, i+1, j+1, dp);
        exc = subseqTD(s, t, i+1, j, dp);

        return dp[i][j] = inc + exc;
    }
    public static int subseqBU(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int inc = 0, exc = 0;
                if (s.charAt(i-1) == t.charAt(j-1))
                    inc = dp[i-1][j-1];
                exc = dp[i-1][j];

                dp[i][j] = inc + exc;
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}
