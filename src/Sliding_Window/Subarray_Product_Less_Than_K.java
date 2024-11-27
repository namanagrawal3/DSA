package Sliding_Window;

public class Subarray_Product_Less_Than_K {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;

        int n = nums.length;
        int count = 0;
        int si = 0, ei = 0;
        int pro = 1;

        while (ei < n) {
            pro *= nums[ei];

            while (pro >= k && si <= ei){
                pro /= nums[si];
                si++;
            }

            count += ei-si+1;
            ei++;
        }

        System.out.println(count);
    }
}
