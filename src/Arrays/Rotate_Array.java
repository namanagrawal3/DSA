package Arrays;

public class Rotate_Array {
    public static void main(String[] args) {

        // Leetcode -> "Rotate Array"

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

//        rotateArray1(arr, k);
        rotateArray2(arr, k);

        for (int i = 0;i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void rotateArray2(int[] arr, int k) {
        int n = arr.length;
        k = k % n;                                  // Reversal Algorithm

        reverseFunc(arr,n-k,n-1);
        reverseFunc(arr,0,n-k-1);
        reverseFunc(arr,0,n-1);
    }
    public static void reverseFunc(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
    public static void rotateArray1(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        while (k-- > 0) {
            int item = arr[n-1];
            for (int i = n-2; i >= 0; i--) {
                arr[i+1] = arr[i];
            }
            arr[0] = item;
        }
    }
}
