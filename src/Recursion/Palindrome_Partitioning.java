package Recursion;

public class Palindrome_Partitioning {
    public static void main(String[] args) {
        String st = "nitin";
        printPartition(st,"");
    }
    public static void printPartition(String que,String ans){
        if(que.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i=1;i<=que.length();i++){
            String part = que.substring(0,i);
            if(isPalindrome(part))
                printPartition(que.substring(i),ans+part+"| ");
        }
    }
    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
