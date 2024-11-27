package CodeSkiller;

import java.util.HashMap;

public class Count_Number_of_Nice_Subarrays {
    public static void main(String[] args) {

        // https://codeskiller.codingblocks.com/problems/3616

        int[] arr = {2,5,6,9};
        // int[] arr = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        replaceItems(arr);
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            int rem = sum-k;
            if(map.containsKey(rem))
                count += map.get(rem);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        System.out.println(count);
    }
    public static void replaceItems(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2 == 0)
                arr[i] = 0;
            else
                arr[i] = 1;
        }
    }
}
