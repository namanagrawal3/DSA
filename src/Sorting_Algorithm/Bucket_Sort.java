package Sorting_Algorithm;

import java.util.*;

public class Bucket_Sort {
    public static void main(String[] args) {

        // Top-K-frequent elements

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] ans = bucketSort(nums, k);

        for (int i = 0; i < k; i++) {
            System.out.print(ans[i] + " ");
        }
    }
    public static int[] bucketSort(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length + 1];            // array of list of integer

        for (int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }

        int idx = 0;
        int[] ans = new int[k];

        for (int i = nums.length; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int val : bucket[i]) {
                    ans[idx++] = val;
                    if(idx == k)
                        return ans;
                }
            }
        }
        return ans;
    }
}
