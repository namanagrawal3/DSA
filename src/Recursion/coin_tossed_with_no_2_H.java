package Recursion;

public class coin_tossed_with_no_2_H {
    public static void main(String[] args) {
        int coins = 4 ;
        printSub(coins,"");
        System.out.println();
        System.out.print(countSub(coins,""));
    }
    public static void printSub(int n,String ans){
        if(n == 0){
            System.out.print(ans+" ");
            return;
        }
        if(ans.length()==0 || ans.charAt(ans.length()-1)!='H')
            printSub(n-1,ans+'H');
        printSub(n-1,ans+'T');
    }
    public static int countSub(int n,String ans){
        if(n == 0){
            return 1;
        }
        int a = 0;
        if(ans.length()==0 || ans.charAt(ans.length()-1)!='H')
            a = countSub(n-1,ans+'H');
        int b = countSub(n-1,ans+'T');
        return a+b;
    }
}
