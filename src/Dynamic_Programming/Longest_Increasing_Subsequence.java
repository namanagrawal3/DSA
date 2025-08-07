package Dynamic_Programming;

import java.util.Arrays;

public class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18, 6};

        System.out.println(n2Approach(nums));
        System.out.println(nlognApproach(nums));
    }
    public static int n2Approach(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];                     // 'len[i]' stores the length of the lis ending at index 'i'
        Arrays.fill(len, 1);

        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    len[i] = Math.max(len[i], len[j]+1);
                }
            }
        }

        int lis = 0;
        for (int i = 0; i < n; i++) {
            if (len[i] > lis)
                lis = len[i];
        }

        return lis;
    }
    public static int nlognApproach(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];                      // stores the end-points of all LIS (in a sorted manner)
        dp[0] = nums[0];
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[len-1]) {
                dp[len] = nums[i];
                len++;
            }
            else {
                int idx = binarySearch(dp, 0, len-1, nums[i]);
                dp[idx] = nums[i];
            }
        }

        return len;
    }
    public static int binarySearch(int[] dp, int si, int ei, int target) {
        while (si <= ei) {
            int mid = si + (ei-si)/2;
            if (dp[mid] >= target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return si;
    }
}
