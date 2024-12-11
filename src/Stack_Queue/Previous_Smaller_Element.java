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
        nslFun(arr);
    }
    public static void nslFun(int[] arr) {
        int n = arr.length;
        int[] nsl = new int[n];
        Stack<Integer> st = new Stack<>();          // Next Smaller to Left

        for (int i = 0; i < n; i++) {
            if (st.isEmpty())
                nsl[i] = -1;
            else {
                while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                    st.pop();
                }
                nsl[i] = (st.isEmpty()) ? -1 : st.peek();
            }

            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            int ans = (nsl[i] == -1) ? -1 : arr[nsl[i]];
            System.out.print(ans + " ");
        }
    }
}
