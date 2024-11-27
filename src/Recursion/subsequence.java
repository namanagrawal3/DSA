package Recursion;

public class subsequence {
    // static int count = 0;
    public static void main(String[] args) {
        String str = "abc";
        printSub(str,"");
        System.out.println(countSub(str,""));                           // 1st way ---> using static variable
        // System.out.println(count);                                       // 2nd way ---> using the given pattern
    }
    public static void printSub(String que,String ans){
        if(que.length() == 0){
            System.out.print(ans+" ");
            // count++;
            return;
        }
        char ch = que.charAt(0);
        printSub(que.substring(1),ans);
        printSub(que.substring(1),ans+ch);
    }
    public static int countSub(String que,String ans){
        if(que.length() == 0){
            return 1;
        }
        char ch = que.charAt(0);
        int a = countSub(que.substring(1),ans);
        int b = countSub(que.substring(1),ans+ch);
        return a+b;
    }
}
