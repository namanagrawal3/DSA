package Recursion;

import java.util.ArrayList;
import java.util.List;

public class coin_Permutation {
    public static void main(String[] args) {
        int[] coins = {2,3,5,6};
        int amount = 10;
        printPermutation(coins,amount,0,"");
    }
    public static void printPermutation(int[] arr,int n,int curr,String ans){
        if(curr == n){
            System.out.print(ans+" ");;
            return;
        }
        if(curr > n)
            return;
        for(int ele:arr){
            printPermutation(arr,n,curr+ele,ans+ele);
        }
    }
}
