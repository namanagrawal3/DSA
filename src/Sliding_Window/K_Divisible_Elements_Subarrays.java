package Sliding_Window;

import java.util.HashSet;

public class K_Divisible_Elements_Subarrays {
    public static void main(String[] args) {
        int[] nums = {2,3,3,2,2};
        int k = 2, p = 2;
        System.out.println(countSub(nums,k,p));
    }
    public static int countSub(int[] nums, int k,int p){
        HashSet<String> set = new HashSet<>();
        int si = 0;
        int ei = 0;
        int count = 0;
        while(ei<nums.length){
            if(nums[ei]%p == 0)
                count++;
            while(count>k && si<=ei){
                if(nums[si]%p == 0)
                    count--;
                si++;
            }
            StringBuilder st = new StringBuilder();
            for(int i=ei;i>=si;i--){
                st.append(nums[i]+" ");
                set.add(st.toString());
            }
            ei++;
        }
        System.out.println(set);
        return set.size();
    }
}
