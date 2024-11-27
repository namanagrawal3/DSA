package Strings;

public class Print_Pallindrome_Substrings {
    public static void main(String[] args) {
        String st="hello";
        printAllPallSubstring(st);
    }
    public static void printAllPallSubstring(String s){
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(checkPallindrome(s.substring(i,j)))
                    System.out.println(s.substring(i,j));
            }
        }
    }
    public static boolean checkPallindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
