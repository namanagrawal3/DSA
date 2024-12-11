package Stack_Queue;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {
    public static void main(String[] args) {

        // just similar to trapping rainwater

        int[] heights = {2,3,5,4,6,1,7};
        Stack<Integer> st = new Stack<>();
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int h = heights[st.pop()];
                int r = i;
                if (!st.isEmpty()) {
                    int l = st.peek();
                    area = Math.max(area, h * (r-l-1));
                }
                else
                    area = Math.max(area, h * r);
            }
            st.push(i);
        }
        int r = heights.length;
        while (!st.isEmpty()) {
            int h = heights[st.pop()];
            if (!st.isEmpty()) {
                int l = st.peek();
                area = Math.max(area, h * (r-l-1));
            }
            else
                area = Math.max(area, h * r);
        }
        System.out.println(area);
        System.out.println(histogramFun(heights));
    }
    public static int histogramFun(int[] arr) {
        int n = arr.length;
        int[] nsr = new int[n];
        int[] nsl = new int[n];

        // -------- finding the 'Next Smaller to Right'
        Stack<Integer> st = new Stack<>();

        for (int i = n-1; i >= 0; i--) {
            if (st.isEmpty())
                nsr[i] = n;
            else {
                while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                    st.pop();
                }
                nsr[i] = (st.isEmpty()) ? n : st.peek();
            }

            st.push(i);
        }

        st.clear();

        // -------- finding the 'Next Smaller to Left'

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

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int area = arr[i] * (nsr[i] - nsl[i] - 1);
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
