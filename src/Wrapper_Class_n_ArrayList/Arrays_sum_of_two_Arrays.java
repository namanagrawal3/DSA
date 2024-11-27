package Wrapper_Class_n_ArrayList;

import java.util.ArrayList;

public class Arrays_sum_of_two_Arrays {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 9};
        int[] brr = {3, 4, 5, 6, 7};

        findSum(arr,brr);
    }
    public static void findSum(int[] arr, int[] brr) {
        int sum = 0;
        int carry = 0;
        ArrayList<Integer> l = new ArrayList<>();

        int i = arr.length-1;
        int j = brr.length-1;

        while (i >= 0 && j >= 0) {
            sum = carry + arr[i] + brr[j];
            l.add(sum % 10);                          // Here we can add the sum at 0-index also everytime but its complexity
            carry = sum / 10;                         // will be O(N) everytime because of copying of data
            i--;
            j--;
        }

        while (i >= 0) {
            sum = arr[i] + carry;
            l.add(sum % 10);
            carry = sum / 10;
            i--;
        }

        while (j >= 0) {
            sum = brr[j] + carry;
            l.add(sum % 10);
            carry = sum / 10;
            j--;
        }

        if (carry > 0)
            l.add(carry);

        for (int k = l.size()-1; k >= 0; k--) {
            System.out.print(l.get(k) + ", ");
        }
        System.out.println("END");
    }
}
