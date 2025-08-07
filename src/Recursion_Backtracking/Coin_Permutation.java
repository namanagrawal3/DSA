package Recursion_Backtracking;

public class Coin_Permutation {
    public static void main(String[] args) {
        int[] coins = {2,3,5,6};
        int amount = 10;

        printPermutation(coins, amount,"");
    }
    public static void printPermutation(int[] arr, int amount, String ans) {
        if (amount == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (amount >= arr[i])
                printPermutation(arr, amount-arr[i], ans + arr[i]);
        }
    }
}
