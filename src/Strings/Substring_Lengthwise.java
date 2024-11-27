package Strings;

public class Substring_Lengthwise {
    public static void main(String[] args) {
        String str = "Hello";
        lengthWise(str);
    }
    public static void lengthWise(String str) {
        int n = str.length();

        for (int len = 1; len <= n; len++) {
            for (int j = len; j <= n; j++) {                           // j-i = len
                int i = j - len;
                System.out.println(str.substring(i, j));
            }
        }
    }
}
