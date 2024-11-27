package Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class Previous_Smaller_Element {
    public static void main(String[] args) {
        int[] arr = {1, 5, 0, 3, 4, 5};
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                ans[st.pop()] = arr[i];
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            ans[st.pop()] = -1;
        }
        System.out.println(Arrays.toString(ans));
    }
}
