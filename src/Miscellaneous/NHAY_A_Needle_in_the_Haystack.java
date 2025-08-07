package Miscellaneous;

import java.util.Scanner;

public class NHAY_A_Needle_in_the_Haystack {
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//
//        while (sc.hasNextInt()) {                   // For unknown no. of testcases
//            int len = sc.nextInt();
//            String pattern = sc.next();
//            String text = sc.next();
//
//            lpsFun(pattern, text);
//        }

        String pattern = "na";
        String text = "banananobano";

        lpsFun(pattern, text);
    }
    public static void lpsFun(String pattern, String text) {
        String s = pattern + "#" + text;             // It is mandatory to separate the pattern by a character ('#')
        int n = s.length();
        int[] dp = new int[n];

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

        for (int j = pattern.length()+1; j < n; j++) {
            if (dp[j] == pattern.length())
                System.out.println(j - 2*pattern.length());
        }
    }
}
