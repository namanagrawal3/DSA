package Stack_Queue;

import java.util.Stack;

public class Maximal_Rectangle {
    public static void main(String[] args) {
        int[][] matrix = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        int row = matrix.length;
        int col = matrix[0].length;

        int[] arr = new int[col];
        int maxArea = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[j] = (matrix[i][j] == 0) ? 0 : arr[j] + 1;
            }
            maxArea = Math.max(maxArea, histogram(arr));
        }
        System.out.println(maxArea);
    }
    public static int histogram(int[] heights) {
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
        return area;
    }
}
