package Binary_Search;

import java.util.Arrays;

public class Book_Allocation_Problem {
    public static void main(String[] args) {
        int[] page = {12, 34, 67, 90};
        int students = 2;

        int n = page.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += page[i];
        }
        int si = 0;
        int ei = sum;
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (isPossible(mid, page, students))
                ei = mid - 1;
            else
                si = mid + 1;
        }

        System.out.println(si);
    }
    public static boolean isPossible(int maxPages, int[] page, int students) {
        int n = page.length;
        int count = 1;
        int readpages = 0;
        int i = 0;

        while (i < n) {
            if (readpages + page[i] <= maxPages){
                readpages += page[i];
                i++;
            }
            else {
                count++;
                readpages = 0;
            }

            if (count > students)
                return false;
        }

        return true;
    }
}
