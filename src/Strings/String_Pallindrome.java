package Strings;

public class String_Pallindrome {
    public static void main(String[] args) {
        String s = "naman";
        System.out.println(checkPallindrome(s));
    }
    public static boolean checkPallindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
