package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 4;                                                              // queen_Combination ---> same question
        int k = 2;
        List<List<Integer>> ans = new ArrayList<>();                            // no need of boolean array in case of combinatiion
        List<Integer> l = new ArrayList<>();
        printCombination(n,k,0,1,l,ans);
        System.out.println(ans);
    }
    public static void printCombination(int n,int k,int curr,int idx,List<Integer> l,List<List<Integer>> ans){
        if(curr == k){
            ans.add(new ArrayList<>(l));
            return;
        }
        for(int i=idx;i<=n;i++){
            l.add(i);
            printCombination(n,k,curr+1,i+1,l,ans);
            l.remove(l.size()-1);
        }
    }
}
