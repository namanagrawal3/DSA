package Binary_Search;

import java.util.Scanner;

public class Search_Element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int item = sc.nextInt();
        int[] arr = {2, 4, 5, 7, 12, 23, 46, 98, 103, 150, 161};

        System.out.println(binarySearch(arr,item));
    }

    public static int binarySearch(int[] arr, int item) {
        int si = 0;
        int ei = arr.length-1;

        while ( si <= ei) {
            int mid = si + (ei-si)/2;
            if (arr[mid] == item)
                return mid;
            else if (arr[mid] > item)
                ei = mid - 1;
            else
                si = mid + 1;
        }

        return -1;
    }
}
