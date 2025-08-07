package Wrapper_Class_n_ArrayList;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] nums = {-5,1,2,-3,4};
        int k = 2;
        int n = nums.length;
        long maxSum = Integer.MIN_VALUE;
        long sum = 0;
        int si = 0, ei = 0;

        while (ei < n) {
            sum += nums[ei];

            if ((ei-si+1) % k == 0)
                maxSum = Math.max(maxSum, sum);

            ei++;
        }

        ei--;
        while (si <= ei) {
            sum -= nums[si];
            si++;

            if ((ei-si+1) % k == 0)
                maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}