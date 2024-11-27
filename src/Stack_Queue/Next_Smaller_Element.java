package Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class Next_Smaller_Element {
    public static void main(String[] args) {
        int[] arr = {3,8,5,2,25};
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
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
