package Arrays;

public class Wiggle_Subsequence {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,5};
        System.out.println(wiggleLength(nums));
    }
    public static int wiggleLength(int[] nums){
        int n = nums.length;
        if(n<=1)
            return n;
        int count = 1;
        int pre_diff = 0;
        for(int i=1;i<n;i++) {
            int diff = nums[i]-nums[i-1];
            if((diff>0 && pre_diff<=0) || (diff<0 && pre_diff>=0)){
                count++;
                pre_diff = diff;
            }
        }
        return count;
    }
}
