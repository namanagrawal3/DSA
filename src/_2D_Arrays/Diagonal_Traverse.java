package _2D_Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class Diagonal_Traverse {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5},
                        {6 ,7, 8, 9, 10},
                        {11,12,13,14,15},
                        {16,17,18,19,20}};
        diag_trav(arr);
        diag_alt_trav(arr);
    }
    public static void diag_trav(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        int diagonals = row+col-1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int d=0;d<diagonals;d++){
            int i=-1,j=-1;
            if(d<col){
                i = 0;
                j = d;
            }
            else{
                i = d-col+1;
                j = col-1;
            }
            ArrayList<Integer> l = new ArrayList<>();
            while(i<row && j>=0){
                l.add(arr[i][j]);
                i++;
                j--;
            }
            ans.add(l);
        }
        System.out.println(ans);
    }
    public static void diag_alt_trav(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        int diagonals = row+col-1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int d=0;d<diagonals;d++){
            int i=-1,j=-1;
            if(d<col){
                i = 0;
                j = d;
            }
            else{
                i = d-col+1;
                j = col-1;
            }
            ArrayList<Integer> l = new ArrayList<>();
            while(i<row && j>=0){
                l.add(arr[i][j]);
                i++;
                j--;
            }
            if(d%2==0){
                Collections.reverse(l);
            }
            ans.add(l);
        }
        System.out.println(ans);
    }
}
