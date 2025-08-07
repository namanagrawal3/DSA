package Dynamic_Programming;

import java.util.Arrays;

public class Minimum_Falling_Path_Sum_II {
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(pathTD(grid));
        System.out.println(pathBU(grid));
    }
    public static int pathTD(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;

        int[][] dp = new int[n][n];
        for (int[] r: dp) {
            Arrays.fill(r, Integer.MIN_VALUE);
        }

        for (int j = 0; j < n; j++) {
            int temp = pathFun(matrix, n, 0, j, dp);
            ans = Math.min(ans, temp);
        }

        return ans;
    }
    public static int pathFun(int[][] mat, int n, int cr, int cc, int[][] dp) {
        if (cr == n-1)
            return mat[cr][cc];
        if (dp[cr][cc] != Integer.MIN_VALUE)
            return dp[cr][cc];

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (j == cc)
                continue;
            int temp = pathFun(mat, n, cr+1, j, dp);
            ans = Math.min(ans, temp);
        }

        return dp[cr][cc] = ans + mat[cr][cc];
    }
    public static int pathBU(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n-1][j] = matrix[n-1][j];
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int minVal = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k == j)
                        continue;
                    minVal = Math.min(minVal, dp[i+1][k]);
                }

                dp[i][j] = minVal + matrix[i][j];
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[0][j]);
        }

        return minSum;
    }
}
