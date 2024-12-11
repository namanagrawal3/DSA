package Sliding_Window;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Sliding_Window_Maximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};          // K-size window "first +ve", "first -ve", "max", "min"
        int k = 3;                                        // In all these questions, (doubly-ended queue) 'Deque' is used

        int n = nums.length;
        int[] ans = new int[n-k+1];

        Deque<Integer> dq = new ArrayDeque<>();          // Monotonic Decreasing order is maintained in a deque
        for (int i = 0; i < k-1; i++) {
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }

        for (int i = k-1; i < n; i++) {
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);

            if (dq.getFirst() <= i-k)
                dq.removeFirst();

            ans[i-k+1] = nums[dq.getFirst()];
        }

        System.out.println(Arrays.toString(ans));

    }
}
