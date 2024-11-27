package Dynamic_Programming;

import java.util.*;

public class Coin_Change_II {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;

        int[][] dp = new int[amount + 1][coins.length];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(coinsTD(coins, amount, 0, dp));

        System.out.println(coinsBU(coins, amount));
    }
    public static int coinsTD(int[] coins, int amount, int idx, int[][] dp) {
        if (amount == 0)
            return 1;
        if (idx == coins.length)
            return 0;

        if (dp[amount][idx] != -1)
            return dp[amount][idx];

        int inc = 0;                                    // will include
        int exc = 0;                                    // will not include
        if (amount >= coins[idx])
            inc = coinsTD(coins, amount - coins[idx], idx, dp);
        exc =  coinsTD(coins, amount, idx + 1, dp);

        return dp[amount][idx] = inc + exc;
    }
    public static int coinsBU(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];

        for (int i = 0; i < dp.length; i++) {           // amount is 0 (Base-Case)
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int inc = 0;
                int exc = 0;

                if (j >= coins[i-1])
                    inc = dp[i][j-coins[i-1]];
                exc = dp[i-1][j];

                dp[i][j] = inc + exc;
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}
