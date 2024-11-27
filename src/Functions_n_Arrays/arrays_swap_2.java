package Functions_n_Arrays;

public class arrays_swap_2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};            // Hardcoded-array
        System.out.println(arr[0] + " " + arr[1]);
        swapFun(arr, 0, 1);
        System.out.println(arr[0] + " " + arr[1]);
    }
    public static void swapFun(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
