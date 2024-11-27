package Arrays;

import java.util.HashSet;

public class Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i< nums.length;i++){
            set.add(nums[i]);
        }
        int maxlen = 0;
        for(int i=0;i< nums.length;i++){
            int ele = nums[i];
            if(set.contains(ele-1))
                continue;
            else{
                int count = 0;
                while(set.contains(ele)){
                    count++;
                    ele = ele+1;
                }
                maxlen = Math.max(maxlen,count);
            }
        }
        System.out.println(maxlen);
    }
}
