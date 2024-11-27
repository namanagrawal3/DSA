package Recursion;

import java.util.Scanner;

public class Rat_Chases_its_Cheese {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maze = new int[n][m];
        for(int i=0;i< maze.length;i++){
            String s = sc.next();
            for(int j=0;j<s.length();j++){
                maze[i][j] = s.charAt(j);
            }
        }
        int[][] ans = new int[n][m];
        printPath(maze,0,0,ans);
        if(!flag)
            System.out.println("NO PATH FOUND");
    }
    static boolean flag = false;
    public static void printPath(int[][] maze,int cr,int cc,int[][] ans){
        // cc ---> current column
        // cr ---> current row

        if(cr== maze.length-1 && cc==maze[0].length-1){
            if(maze[cr][cc] == 'O'){
                flag = true;
                ans[cr][cc] = 1;
                display(ans);
                ans[cr][cc] = 0;
            }
            return;
        }

        if(cr<0 || cr> maze.length-1 || cc<0 || cc>maze[0].length-1 || maze[cr][cc]=='X')
            return;

        maze[cr][cc] = 'X';
        ans[cr][cc] = 1;

        printPath(maze,cr,cc+1,ans);    // right
        printPath(maze,cr-1,cc,ans);    // up
        printPath(maze,cr,cc-1,ans);    // left
        printPath(maze,cr+1,cc,ans);    // down

        maze[cr][cc] = 'O';           // Backtracking
        ans[cr][cc] = 0;
    }
    public static void display(int[][] ans){
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
