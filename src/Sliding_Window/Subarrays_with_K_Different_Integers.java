package Sliding_Window;

import java.util.HashMap;

public class Subarrays_with_K_Different_Integers {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarrayCount(nums,k)-subarrayCount(nums,k-1));
    }
    public static int subarrayCount(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int si = 0;
        int ei = 0;
        int count = 0;
        while(ei<nums.length){
            map.put(nums[ei], map.getOrDefault(nums[ei],0)+1);
            while(map.size()>k && si<=ei){
                map.put(nums[si], map.get(nums[si])-1);
                if(map.get(nums[si]) == 0)
                    map.remove(nums[si]);
                si++;
            }
            count += ei-si+1;
            ei++;
        }
        return count;
    }
}
