package Recursion_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        printComb(candidates, target,0, new ArrayList<>(), ans);
        System.out.println(ans);
    }
    public static void printComb(int[] arr, int target, int idx, List<Integer> l, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(l));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i-1])
                continue;

            if (target >= arr[i]) {
                l.add(arr[i]);
                printComb(arr, target-arr[i], i+1, l, ans);
                l.remove(l.size()-1);
            }
        }
    }
}
