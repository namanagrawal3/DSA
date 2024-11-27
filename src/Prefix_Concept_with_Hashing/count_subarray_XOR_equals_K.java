package Prefix_Concept_with_Hashing;

import java.util.HashMap;

public class count_subarray_XOR_equals_K {
    public static void main(String[] args) {
        int[] arr = {4,2,2,6,4};
        int k = 6;
        int xor = 0;
        int count = 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<arr.length;i++){
            xor ^= arr[i];
            int x = xor^k;
            if(map.containsKey(x))
                count += map.get(x);
            map.put(xor,map.getOrDefault(xor,0)+1);
        }
        System.out.println(count);
    }
}
