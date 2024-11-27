package Sliding_Window;

import java.util.Scanner;

public class Kartik_bhaiya_and_Strings {
    public static void main(String[] args) {
        String s = "aaabaababbaa";
        int k = 2;

        int c1 = maxlen(s, k,'a');
        int c2 = maxlen(s, k,'b');

        System.out.println(Math.max(c1, c2));
    }
    public static int maxlen(String s, int k, char item) {
        int n = s.length();
        int si = 0, ei = 0;
        int flip = 0;
        int maxLen = 0;

        while (ei < n) {
            char ch = s.charAt(ei);
            if (ch == item)
                flip++;

            while (flip > k && si <= ei) {
                if (s.charAt(si) == item)
                    flip--;
                si++;
            }

            maxLen = Math.max(maxLen, ei-si+1);
            ei++;
        }

        return maxLen;
    }
}
