package Recursion_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    public static void main(String[] args) {
        String s = "nitin";

        List<List<String>> ans = new ArrayList<>();
        partitionFun(s, new ArrayList<>(), ans);
        System.out.println(ans);
    }
    public static void partitionFun(String que, List<String> l, List<List<String>> ans) {
        if (que.length() == 0) {
            ans.add(new ArrayList<>(l));
            return;
        }

        for (int i = 0; i < que.length(); i++) {
            String part = que.substring(0, i+1);
            if (isPalindrome(part)) {
                l.add(part);
                partitionFun(que.substring(i+1), l, ans);
                l.remove(l.size()-1);
            }

        }
    }
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }
        return true;
    }
}
