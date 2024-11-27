package Recursion;

public class Permutation_1 {
    public static void main(String[] args) {
        String st = "abc";
        printPermutation(st,"");
    }
    public static void printPermutation(String que,String ans){
        if(que.length() == 0){
            System.out.print(ans+" ");
            return;
        }
        for(int i=0;i<que.length();i++){
            char ch = que.charAt(i);
            String QUE = que.substring(0,i) + que.substring(i+1);
            printPermutation(QUE,ans+ch);
        }
    }
}
