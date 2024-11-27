package Dynamic_Programming;

import java.util.Arrays;

public class Longest_Common_Substring {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "acdghr";

        System.out.println(subStringBU(s1, s2));
    }
    public static int subStringBU(String a, String b) {
        int[][] dp = new int[a.length()+1][b.length()+1];
        int maxLen = 0;
        // first row & first col --> 0

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i-1) == b.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = 0;

                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        StringBuilder ans = new StringBuilder();            // printing the longest common substring
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (dp[i][j] == maxLen) {
                    while (dp[i][j] != 0) {
                        ans.append(a.charAt(i-1));
                        i--;
                        j--;
                    }
                    System.out.println(ans.reverse());
                    return maxLen;
                }
            }
        }
        return 0;
    }
}
