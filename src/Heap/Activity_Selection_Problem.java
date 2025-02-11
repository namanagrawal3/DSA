package Heap;

import java.util.Arrays;
import java.util.Comparator;

public class Activity_Selection_Problem {
    public static void main(String[] args) {
        int[] start = {1, 3, 2, 5};
        int[] end = {2, 4, 3, 6};

        int n = start.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }

        Arrays.sort(arr, new Comparator<int[]>() {        // sort on the basis of 'end time'
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int cntAct = 1;
        int maxEnd = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (arr[i][0] > maxEnd) {
                cntAct++;
                maxEnd = arr[i][1];
            }
        }

        System.out.println(cntAct);
    }
}
