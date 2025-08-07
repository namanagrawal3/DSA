package Recursion_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_Lexicographically {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};

        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        subSetLexico(arr, 0, l, ans);
        System.out.println(ans);
    }
    public static void subSetLexico(int[] arr, int idx, List<Integer> l, List<List<Integer>> ans) {
        if (idx == arr.length) {
            ans.add(new ArrayList<>(l));
            return;
        }

        ans.add(new ArrayList<>(l));

        for (int i = idx; i < arr.length; i++) {
            l.add(arr[i]);
            subSetLexico(arr, i+1, l, ans);
            l.remove(l.size()-1);
        }
    }
}
