package Two_Pointers;

import java.util.Arrays;

public class K_diff_Pairs_in_an_Array {
    public static void main(String[] args) {
        int[] nums = {1,3,1,5,4};
        int k = 0;
        usingTwoPointers(nums,k);
        //usingHashMap(nums,k);
    }
    public static void usingTwoPointers(int[] nums,int k){
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int j = 1;
        while(i<n && j<n){
            int diff = nums[j]-nums[i];
            if(diff == k){
                count++;
                i++;
                j++;
                while(j<n && nums[j]==nums[j-1]){
                    j++;
                }
            }
            else if(diff > k){
                i++;
                if(j-i == 0)
                    j++;
            }
            else
                j++;
        }
        System.out.println(count);
    }
}
