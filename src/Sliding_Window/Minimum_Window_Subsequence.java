package Sliding_Window;

public class Minimum_Window_Subsequence {
    public static void main(String[] args) {
        String s = "abcgdebbde";
        String t = "bde";

        int n = s.length();
        int m = t.length();
        int start = -1;
        int minLen = n + 1;

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;

                if (j == m) {
                    int end = i;
                    j--;
                    while (j >= 0) {
                        if (s.charAt(i) == t.charAt(j))
                            j--;
                        i--;
                    }

                    i++;
                    if ((end-i+1) < minLen) {
                        minLen = end-i+1;
                        start = i;
                    }

                    j++;
                    i++;
                }
            }
        }

        if (start == -1)
            return;
        System.out.println(s.substring(start, start + minLen));
    }
}
