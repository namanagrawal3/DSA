package Dynamic_Programming;
import java.util.*;

public class Minimum_Falling_Path_Sum {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};

        System.out.println(pathTD(matrix));
        System.out.println(pathBU(matrix));
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

        int leftDiag = (cc > 0) ? pathFun(mat, n, cr+1, cc-1, dp) : Integer.MAX_VALUE;
        int below = pathFun(mat, n, cr+1, cc, dp);
        int rightDiag = (cc < n-1) ? pathFun(mat, n, cr+1, cc+1, dp) : Integer.MAX_VALUE;

        return dp[cr][cc] = Math.min(below, Math.min(leftDiag, rightDiag)) + mat[cr][cc];
    }
    public static int pathBU(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n-1][j] = matrix[n-1][j];
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int leftDiag = (j > 0) ? dp[i+1][j-1] : Integer.MAX_VALUE;
                int below = dp[i+1][j];
                int rightDiag = (j < n-1) ? dp[i+1][j+1] : Integer.MAX_VALUE;

                dp[i][j] = Math.min(below, Math.min(leftDiag, rightDiag)) + matrix[i][j];
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, dp[0][j]);
        }

        return minSum;
    }
}
