package Miscellaneous;

public class KMP_Longest_Happy_Prefix {
    public static void main(String[] args) {
        String s = "aabaacfaabaa";

        System.out.println(lpsFun(s));                          // KMP String-Matching Algorithm
    }
    public static String lpsFun(String s) {
        int n = s.length();
        int[] dp = new int[n];            // dp[i] stores the length of the LPS upto index i

        int len = 0;
        dp[0] = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                dp[i] = len;
                i++;
            }
            else {
                if (len > 0)
                    len = dp[len-1];
                else {
                    dp[i] = 0;
                    i++;
                }
            }
        }

        return s.substring(0, dp[n-1]);
    }
}
