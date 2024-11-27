package Dynamic_Programming;

public class Minimum_Subset_Sum_Difference {
    public static void main(String[] args) {
        int[] nums = {1, 6, 11, 5};

        System.out.println(subsetFun(nums));
    }
    public static int subsetFun(int[] nums) {
        // let s2 > s1 --> minimise (s2-s1)
        // s1+s2 = sum --> minimise (sum - 2s1)
        //  0 <= s1 <= sum/2

        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // now check the 'Subset Sum Problem' for values in range [0, sum/2];
        boolean[][] dp = new boolean[n+1][sum/2 +1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                boolean take = false, not_take = false;
                if (j >= nums[i-1])
                    take = dp[i-1][j-nums[i-1]];
                not_take = dp[i-1][j];

                dp[i][j] = take || not_take;
            }
        }

        for (int j = dp[0].length-1; j >= 0; j--) {
            if (dp[n][j] == true)
                return sum - (2*j);
        }
        return 0;
    }
}
