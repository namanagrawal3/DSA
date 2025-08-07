package Recursion_Backtracking;

public class Coin_Combination {
    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 6};
        int amount = 10;

        printCombination(coins, amount,"",0);
    }
    public static void printCombination(int[] arr, int amount, String ans, int idx) {
        if (amount == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (amount >= arr[i])
                printCombination(arr, amount-arr[i],ans+arr[i], i);
        }
    }
}
