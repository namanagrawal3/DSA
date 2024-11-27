package _2D_Arrays;

public class _2D_Array_demo {
    public static void main(String[] args) {
        int[][] arr = new int[3][4];
        System.out.println(arr);                    // It will print its address like [[I@_____
                                                    // where '[[' means 2-D array , 'I' means Integer

        int[][] other = arr;                        // Here no new array will get created ,only reference variable will get created
        System.out.println(other);

        System.out.println(arr.length);             // length of row
        System.out.println(arr[0].length);          // length of column

        System.out.println(arr[1][2]);
    }
}
