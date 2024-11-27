package Prefix_Concept_with_Hashing;

import java.util.HashMap;

public class count_subarray_sum_equals_K {
    public static void main(String[] args) {
        int[] arr = {1,2,3,-3,1,1,1,4,2,-3};
        int k = 3;
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        int pre_sum = 0;
        int count = 0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            pre_sum += arr[i];
            int rem = pre_sum-k;
            // count += map.getOrDefault(rem,0);
            if(map.containsKey(rem))
                count += map.get(rem);
            map.put(pre_sum,map.getOrDefault(pre_sum,0)+1);
        }
        System.out.println(count);
    }
}
