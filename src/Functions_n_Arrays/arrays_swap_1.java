package Functions_n_Arrays;

public class arrays_swap_1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};            // Hardcoded-array
        System.out.println(arr[0] + " " + arr[1]);
        swapFun(arr[0], arr[1]);
        System.out.println(arr[0] + " " + arr[1]);
    }
    public static void swapFun(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
