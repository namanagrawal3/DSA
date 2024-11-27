package Greedy_Algorithms;

import java.util.HashMap;

public class Minimum_no_of_Operations_to_make_Array_Empty {
    public static void main(String[] args) {
        int[] nums = {14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12};
        System.out.println(minOpr_1(nums));
        System.out.println(minOpr_2(nums));
    }
    public static int minOpr_1(int[] nums){
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int opr = 0;
        for(int key: map.keySet()){
            int fre = map.get(key);
            if(fre == 1)
                return -1;
            if(fre==2 || fre==3)
                opr += 1;
            else{
                if(fre%3 == 0)
                    opr += fre/3;
                else{
                    int rem = fre%3;
                    if(rem == 1){
                        opr += 2;
                        fre -= 4;
                        opr += fre/3;
                    }
                    else{
                        opr += 1;
                        fre -= 2;
                        opr += fre/3;
                    }
                }
            }
        }
        return opr;
    }
    public static int minOpr_2(int[] nums){
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int opr = 0;
        for(int key: map.keySet()){
            int fre = map.get(key);
            if(fre == 1)
                return -1;
            opr += Math.ceil((double)fre/3);
        }
        return opr;
    }
}
