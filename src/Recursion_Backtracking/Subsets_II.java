package Recursion_Backtracking;
import java.util.*;

public class Subsets_II {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};

    // We will generate subsets starting with each unique element (i.e, lexicographically)
    // and we will avoid the call for the duplicate elements
    // we will make a call only for first occurence of element because it will cover all the possible subsets

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        subSetFun(nums, 0, l, ans);
        System.out.println(ans);
    }
    public static void subSetFun(int[] arr, int idx, List<Integer> l, List<List<Integer>> ans) {
        if (idx == arr.length) {
            ans.add(new ArrayList<>(l));                                // Approach-1 (Optimised)
            return;
        }

        ans.add(new ArrayList<>(l));

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i-1])
                continue;

            l.add(arr[i]);
            subSetFun(arr, i+1, l, ans);
            l.remove(l.size()-1);
        }
    }
    public static void subsets(int[] nums,int idx,List<Integer> l,List<List<Integer>> ans) {
        if (idx == nums.length) {
            if (!ans.contains(l))                                       // Approach-2 (Basic)
                ans.add(new ArrayList<>(l));
            return;
        }

        subsets(nums,idx+1, l, ans);

        l.add(nums[idx]);
        subsets(nums, idx + 1, l,ans );
        l.remove(l.size() - 1);
    }
}
