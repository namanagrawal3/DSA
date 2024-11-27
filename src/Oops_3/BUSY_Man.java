package Oops_3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BUSY_Man {
    public static class Pair {
        int start;
        int end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Pair[] arr = new Pair[n];

            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                arr[i] = new Pair(s, e);
            }

            Arrays.sort(arr, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.end - o2.end;
                }
            });

            int end = arr[0].end;
            int maxTask = 1;
            for (int i = 1; i < n; i++) {
                int curr_start = arr[i].start;
                int curr_end = arr[i].end;

                if (curr_start >= end) {
                    maxTask++;
                    end = curr_end;
                }
            }

            System.out.println(maxTask);
        }
    }
}
