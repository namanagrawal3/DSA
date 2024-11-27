package HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Intersection_of_Multiple_Arrays {
    public static void main(String[] args) {
        int[][] nums = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};                   // Each value in nums[i] is unique
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums[0]) {
            map.put(num, 1);
        }

        for (int i = 1; i < n; i++) {
            for (int num : nums[i]) {
                if (map.containsKey(num))
                    map.put(num, map.get(num) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == n)
                ans.add(key);
        }
        Collections.sort(ans);

        System.out.println(ans);
    }
}
