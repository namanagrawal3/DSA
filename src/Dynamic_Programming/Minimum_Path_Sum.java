package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class Minimum_Path_Sum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};

        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] r: dp) {
            Arrays.fill(r, -1);
        }
        System.out.println(pathFunTD(grid, 0, 0, dp));

        System.out.println(pathFunBU(grid));
    }
    public static int pathFunTD(int[][] grid, int cr, int cc, int[][] dp) {
        if (cr == grid.length-1 && cc == grid[0].length-1)
            return grid[cr][cc];
        if (cr >= grid.length || cc >= grid[0].length)
            return Integer.MAX_VALUE;

        if (dp[cr][cc] != -1)
            return dp[cr][cc];

        int right = pathFunTD(grid, cr, cc+1, dp);
        int down = pathFunTD(grid, cr+1, cc, dp);

        return dp[cr][cc] = Math.min(right, down) + grid[cr][cc];
    }
    public static int pathFunBU(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}
