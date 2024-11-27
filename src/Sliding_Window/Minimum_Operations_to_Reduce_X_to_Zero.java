package Sliding_Window;

public class Minimum_Operations_to_Reduce_X_to_Zero {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        int x = 10;
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        int reqSum = sum-x;
        int len = maxSubarray(nums,reqSum);
        if(len == -1)
            System.out.println(-1);
        else
            System.out.println(n-len);
    }
    public static int maxSubarray(int[] arr,int reqSum){
        int sum = 0;
        int maxLen = -1;
        int si = 0;
        int ei = 0;
        while(ei<arr.length){
            sum += arr[ei];
            while(sum>reqSum && si<=ei){
                sum -= arr[si];
                si++;
            }
            if(sum == reqSum)
                maxLen = Math.max(maxLen,ei-si+1);
            ei++;
        }
        return maxLen;
    }
}
