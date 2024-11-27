package Stack_Queue;

import java.util.*;

public class Stock_Span {
    public static void main(String[] args) {

        // 'Sunny Building' Que

        int[] arr = {3,1,6,4,18,7,5,11,10};
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {                                       // O(2*N) --> O(N)
            while (!st.isEmpty() && arr[i] >= arr[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                ans[i] = i + 1;
            else
                ans[i] = i - st.peek();
            st.push(i);
        }
        System.out.println(Arrays.toString(ans));
    }
}
