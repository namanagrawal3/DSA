package Recursion_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III {
    public static void main(String[] args) {
        int n = 7;
        int k = 3;

        List<List<Integer>> ans = new ArrayList<>();
        combSumIII(k, n,1, new ArrayList<>(), ans);
        System.out.println(ans);
    }
    public static void combSumIII(int k, int n, int idx, List<Integer> l, List<List<Integer>> ans) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(l));
            return;
        }

        for (int i = idx; i <= 9; i++) {
            if (n >= i) {
                l.add(i);
                combSumIII(k-1, n-i, i+1, l, ans);
                l.remove(l.size()-1);
            }
        }
    }
}
