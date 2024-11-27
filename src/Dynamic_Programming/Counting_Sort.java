package Dynamic_Programming;

import java.util.Arrays;

public class Counting_Sort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 0, 1, 2, 5, 4, 0, 2, 8, 7, 9, 2, 6, 1, 9};

        int[] ans = sort(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] sort(int[] arr) {
        int key = Arrays.stream(arr).max().getAsInt();
        int[] freq = new int[key+1];

        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }
        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i-1] + freq[i];
        }

        int[] ans = new int[arr.length];
        for (int i = arr.length-1 ; i >= 0; i--) {          // to maintain the relative order same
            int idx = freq[arr[i]] - 1;
            ans[idx] = arr[i];
            freq[arr[i]]--;
        }

        return ans;
    }
}
