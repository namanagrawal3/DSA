package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        printComb(candidates,target,0,0,l,ans);
        System.out.println(ans);
    }
    public static void printComb(int[] arr,int target,int curr,int idx,List<Integer> l,List<List<Integer>> ans){
        if(curr == target){
            ans.add(new ArrayList<>(l));
            return;
        }
        if(curr > target)
            return;
        for(int i=idx;i<arr.length;i++){
            if(i!=idx && arr[i]==arr[i-1])
                continue;
            l.add(arr[i]);
            printComb(arr,target,curr+arr[i],i+1,l,ans);
            l.remove(l.size()-1);
        }
    }
}
