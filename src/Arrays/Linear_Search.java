package Arrays;

import java.util.Scanner;

public class Linear_Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {3, 5, 6, 7, 89, 1, 9};
        int item = sc.nextInt();
        System.out.println(linearSearch(arr,item));
    }

    public static int linearSearch(int[] arr, int item) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == item)
                return i;
        }
        return -1;
    }
}
