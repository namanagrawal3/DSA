package HashMap;
import java.util.*;

public class Intersection_of_Two_Arrays_II {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> l = new ArrayList<>();

        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                map.put(num, map.get(num) - 1);
                l.add(num);
            }
        }

        int[] ans = new int[l.size()];
        int idx = 0;
        for (int ele : l) {
            ans[idx++] = ele;
        }

        System.out.println(Arrays.toString(ans));
    }
}
