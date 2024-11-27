package Recursion;

public class coin_tossed {
    public static void main(String[] args) {
        int coins = 3;
        printSub(coins,"");
        System.out.println();
        System.out.print(countSub(coins,""));
    }
    public static void printSub(int n,String ans){
        if(n == 0){
            System.out.print(ans+" ");
            return;
        }
        printSub(n-1,ans+'H');
        printSub(n-1,ans+'T');
    }
    public static int countSub(int n,String ans){
        if(n == 0){
            return 1;
        }
        int a = countSub(n-1,ans+'H');
        int b = countSub(n-1,ans+'T');
        return a+b;
    }
}
