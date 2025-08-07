package Dynamic_Programming;

import java.util.Arrays;

public class House_Robber {
    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 11};

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(robTD(arr,0, dp));

        System.out.println(robBU(arr));
    }
    public static int robTD(int[] arr, int idx, int[] dp) {
        if (idx >= arr.length)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];

        int rob = arr[idx] + robTD(arr, idx+2, dp);
        int not_rob = robTD(arr, idx+1, dp);

        return dp[idx] = Math.max(rob, not_rob);
    }
    public static int robBU(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];            // 'dp[i]' stores the max money that can be robbed from house at index 'i' to '0'
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            int rob = arr[i] + dp[i-2];
            int not_rob = dp[i-1];

            dp[i] = Math.max(rob, not_rob);
        }

        return dp[n-1];
    }
}
