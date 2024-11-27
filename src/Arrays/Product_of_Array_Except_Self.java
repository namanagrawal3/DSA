package Arrays;

public class Product_of_Array_Except_Self {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        int n = arr.length;

        int[] pre = new int[n];                               //  Prefix-Suffix Concept
        int[] suf = new int[n];

        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1] * arr[i-1];
        }

        suf[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            suf[i] = suf[i+1] * arr[i+1];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = pre[i] * suf[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
