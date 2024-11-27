package Binary_Search;

import java.util.Arrays;

public class Aggressive_Cows {
    public static void main(String[] args) {
        int[] stall = {1, 2, 8, 4, 9};
        int cow = 3;

        int n = stall.length;
        Arrays.sort(stall);                                     // Because stalls are arranged on a straight line

        int si = 1;
        int ei = stall[n-1] - stall[0];
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (isPossible(mid, stall, cow))
                si = mid + 1;
            else
                ei = mid - 1;
        }

        System.out.println(ei);
    }
    public static boolean isPossible(int dist, int[] stall,int cows) {
        int n = stall.length;
        int count = 1;

        int i = 0, j = 1;
        while (j < n) {
            if (stall[j] - stall[i] >= dist) {
                count++;
                i = j;
            }

            if (count == cows)
                return true;
            j++;
        }

        return false;
    }
}
