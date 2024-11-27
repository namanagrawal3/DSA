package Two_Pointers;

import java.util.HashMap;

public class Count_the_Number_of_Good_Partitions {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,3,4};
        System.out.println(countPart(nums));
    }
    public static int countPart(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int count = 1;
        int i = 0;
        int j = 0;
        j = Math.max(j, map.get(nums[0]));
        while(i<nums.length){
            if(i>j){
                count *= 2;
                count %= 1000000007;
            }
            j = Math.max(j, map.get(nums[i]));
            i++;
        }
        return count;
    }
}
