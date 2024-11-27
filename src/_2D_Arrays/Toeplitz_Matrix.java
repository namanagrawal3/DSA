package _2D_Arrays;

public class Toeplitz_Matrix {
    public static void main(String[] args) {

        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(checkToeplitz(matrix));
    }
    public static boolean checkToeplitz(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] != matrix[i-1][j-1])
                    return false;
            }
        }

        return true;
    }
}
