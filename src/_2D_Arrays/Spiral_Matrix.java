package _2D_Arrays;

public class Spiral_Matrix {
    public static void main(String[] args) {

        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiral(arr);
    }
    public static void spiral(int[][] arr) {
        int top = 0, bottom = arr.length-1;
        int left = 0, right = arr[0].length-1;

        int total_ele = arr.length * arr[0].length;
        int count = 0;

        while (count < total_ele) {
            for (int i = left; i <= right && count < total_ele; i++) {
                System.out.print(arr[top][i] + " ");
                count++;
            }
            top++;

            for (int i = top; i <= bottom && count < total_ele; i++) {
                System.out.print(arr[i][right] + " ");
                count++;
            }
            right--;

            for (int i = right; i >= left && count < total_ele; i--) {
                System.out.print(arr[bottom][i] + " ");
                count++;
            }
            bottom--;

            for (int i = bottom; i >= top && count < total_ele; i--) {
                System.out.print(arr[i][left] + " ");
                count++;
            }
            left++;
        }
    }
}
