package Two_Pointers;

import java.util.Arrays;

public class Valid_Triangle_Number {
    public static void main(String[] args) {
        int[] nums = {4,2,3,4};
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);

        for(int i=n-1;i>=2;i--){
            int low = 0;
            int high = i-1;
            while(low<high){
                if(nums[low]+nums[high] > nums[i]){
                    count += high-low;
                    high--;
                }
                else
                    low++;
            }
        }
        System.out.println(count);
    }
}
