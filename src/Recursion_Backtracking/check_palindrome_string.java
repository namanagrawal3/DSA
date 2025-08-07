package Recursion_Backtracking;

public class check_palindrome_string {
    public static void main(String[] args) {
        String s1 = "NAMAN";
        String s2 = "P";
        String s3 = "MADSM";
        System.out.println(checkPalin(s1,0));
        System.out.println(checkPalin(s2,0));
        System.out.println(checkPalin(s3,0));
    }
    public static boolean checkPalin(String s,int idx){
        int n = s.length();
        if(idx == n/2)
            return true;
        if(s.charAt(idx) != s.charAt(n-1-idx))
            return false;
        return checkPalin(s,idx+1);
    }
}
