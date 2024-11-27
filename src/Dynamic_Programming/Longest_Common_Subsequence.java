package Dynamic_Programming;

import java.util.*;

public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";

        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(lcsTD(text1, text2, 0, 0, dp));

        System.out.println(lcsBU(text1, text2));
    }
    public static int lcsTD(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length() || j == s2.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = 1 + lcsTD(s1, s2, i+1, j+1, dp);
        }
        else {
            int one = lcsTD(s1, s2, i+1, j, dp);
            int two = lcsTD(s1, s2, i, j+1, dp);
            ans = Math.max(one, two);
        }

        return dp[i][j] = ans;
    }
    public static int lcsBU(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else {
                    int one = dp[i-1][j];
                    int two = dp[i][j-1];
                    dp[i][j] = Math.max(one, two);
                }
            }
        }

        StringBuilder ans = new StringBuilder();            // Printing the longest common subsequence
        int i = dp.length-1;
        int j = dp[0].length-1;
        while (dp[i][j] != 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                ans.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else {
                if (dp[i-1][j] >= dp[i][j-1])
                    i--;
                else
                    j--;
            }
        }
        System.out.println(ans.reverse());

        return dp[dp.length-1][dp[0].length-1];
    }
}
