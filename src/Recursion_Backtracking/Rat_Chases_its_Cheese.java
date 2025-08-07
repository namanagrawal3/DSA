package Recursion_Backtracking;

import java.util.Scanner;

public class Rat_Chases_its_Cheese {
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                maze[i][j] = s.charAt(j);
            }
        }

        int[][] ans = new int[n][m];
        flag = false;
        printPath(maze, n, m,0,0, ans);

        if (!flag)
            System.out.println("NO PATH FOUND");
    }
    public static void printPath(int[][] maze, int n, int m, int cr, int cc, int[][] ans) {
        // cc ---> current column
        // cr ---> current row
        if (cr < 0 || cr >= n || cc < 0 || cc >= m || maze[cr][cc] != 'O')
            return;

        if (cr == n-1 && cc == m-1) {
            flag = true;
            ans[cr][cc] = 1;
            display(ans);
            ans[cr][cc] = 0;
            return;
        }

        maze[cr][cc] = 'X';
        ans[cr][cc] = 1;

        printPath(maze, n, m, cr,cc+1, ans);    // right
        printPath(maze, n, m,cr-1, cc, ans);    // up
        printPath(maze, n, m, cr,cc-1, ans);    // left
        printPath(maze, n, m,cr+1, cc, ans);    // down

        maze[cr][cc] = 'O';           // Backtracking (Undoing the changes)
        ans[cr][cc] = 0;
    }
    public static void display(int[][] ans) {
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] +" ");
            }
            System.out.println();
        }
    }
}
