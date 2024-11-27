package _2D_Arrays;

public class Search_a_2D_Matrix_II {
    public static void main(String[] args) {
        int[][] arr = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;

        System.out.println(findExistence(arr, target));
    }
    public static boolean findExistence(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n-1;
        while (i < m && j >= 0) {                         // Stair-Case Search
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                j--;
            else
                i++;
        }

        return false;
    }
}
