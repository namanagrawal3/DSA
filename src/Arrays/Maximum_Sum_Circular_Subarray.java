package Arrays;

public class Maximum_Sum_Circular_Subarray {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-3};
        int n = nums.length;

        // ans1 --> maximum sum subarray
        int ans1 = Integer.MIN_VALUE;
        int curr_sum = 0;

        for (int i = 0; i < n; i++) {
            curr_sum += nums[i];                                    // Kadane's Algorithm for maximum sum
            ans1 = Math.max(ans1, curr_sum);

            if(curr_sum < 0)
                curr_sum = 0;
        }

        // ans2 --> circular maximum sum
        // circular maximum sum --> total sum - minimum sum subarray
        int min_sum = Integer.MAX_VALUE;
        int total_sum = 0;
        curr_sum = 0;

        for (int i = 0; i < n; i++) {
            curr_sum += nums[i];                                      // Kadane's Algorithm for minimum sum
            min_sum = Math.min(min_sum, curr_sum);

            if (curr_sum > 0)
                curr_sum = 0;

            total_sum += nums[i];
        }
        int ans2 = total_sum - min_sum;

        if (ans1 > 0)
            System.out.println(Math.max(ans1, ans2));
        else
            System.out.println(ans1);
    }
}
