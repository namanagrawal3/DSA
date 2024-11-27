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
    }
}
