package Recursion;

public class Unique_Paths_III {
    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        int cr=-1, cc=-1;
        int zero = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    cr = i;
                    cc = j;
                }
                if(grid[i][j] == 0)
                    zero++;
            }
        }
        System.out.println(countPaths(grid,cr,cc,zero));
    }
    public static int countPaths(int[][] grid,int cr,int cc,int zero){
        if(cr<0 || cr>=grid.length || cc<0 || cc>=grid[0].length || grid[cr][cc]==-1)
            return 0;
        if(grid[cr][cc] == 2){
            if(zero == -1)
                return 1;
            return 0;
        }
        int[] r = {0,1,0,-1};
        int[] c = {1,0,-1,0};
        grid[cr][cc] = -1;
        int count = 0;
        for(int i=0;i<r.length;i++){
            count += countPaths(grid,cr+r[i],cc+c[i],zero-1);
        }
        grid[cr][cc] = 0;
        return count;
    }
}
