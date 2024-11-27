package Strings;

public class Substring_Demo {
    public static void main(String[] args) {
        String s = "hello";

        System.out.println(s.substring(1, 5));                // 5th index is not included
        System.out.println(s.substring(2));
        System.out.println(s.substring(2, 2));                // empty string

        printAllSubstring("hello");
    }
    public static void printAllSubstring(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n; j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }
}
