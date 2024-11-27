package Recursion;
import java.util.*;

public class Subsets_II {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        subsets(nums,0,l,ans);
        System.out.println(ans);
    }
    public static void subsets(int[] nums,int idx,List<Integer> l,List<List<Integer>> ans) {
        if (idx == nums.length) {
            if (!ans.contains(l))
                ans.add(new ArrayList<>(l));
            return;
        }
        subsets(nums,idx+1, l, ans);
        l.add(nums[idx]);
        subsets(nums, idx + 1, l,ans );
        l.remove(l.size() - 1);
    }
}
