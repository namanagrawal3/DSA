package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III {
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        combSumIII(k,0,n,0,l,ans,1);
        System.out.println(ans);
    }
    public static void combSumIII(int k,int curr,int n,int curr_sum,List<Integer> l,List<List<Integer>> ans,int idx){
        if(curr==k && curr_sum==n){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=idx;i<=9;i++){
            l.add(i);
            combSumIII(k,curr+1,n,curr_sum+i,l,ans,i+1);
            l.remove(l.size()-1);
        }
    }
}
