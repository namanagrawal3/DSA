package Functions_n_Arrays;

public class arrays_swap_3 {
    public static void main(String[] args) {

        // best example to illustrate that "Java is call-by value, not call-by reference"

        int[] arr = {1, 2, 3, 4, 5};
        int[] other = {10, 20, 30, 40, 50};

        System.out.println(arr[0] + " " + other[0]);
        swapFun(arr, other);
        System.out.println(arr[0] + " " + other[0]);
    }
    public static void swapFun(int[] arr, int[] other) {
        int[] temp = arr;
        arr = other;                                             // swapping took place only in this function frame
        other = temp;
    }
}
