package Dynamic_Programming;

import java.util.Arrays;

public class MCM {
    public static void main(String[] args) {
        int[] dim = {1, 2, 3, 4, 3};
        int n = dim.length;

        int[][] dp = new int[n][n];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        System.out.println(matrixFun(dim, 0, n-2, dp));
    }
    public static int matrixFun(int[] dim, int i, int j, int[][] dp) {
        if (i == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int left = matrixFun(dim, i, k, dp);
            int right = matrixFun(dim, k+1, j, dp);
            int temp = left + right + (dim[i] * dim[k+1] * dim[j+1]);

            ans = Math.min(ans, temp);
        }

        return dp[i][j] = ans;
    }
}
