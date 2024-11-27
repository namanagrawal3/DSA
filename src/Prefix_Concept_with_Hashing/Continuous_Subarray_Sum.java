package Prefix_Concept_with_Hashing;

import java.util.HashMap;

public class Continuous_Subarray_Sum {
    public static void main(String[] args) {
        int[] nums = {5,0,0,0};
        int k = 3;
        System.out.println(check(nums,k));
    }
    public static boolean check(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int rem = sum%k;
            if(map.containsKey(rem)){
                if(i-map.get(rem)>=2)
                    return true;
            }
            else
                map.put(rem,i);
        }
        return false;
    }
}
