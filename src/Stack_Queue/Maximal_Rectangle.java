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

            maxArea = Math.max(maxArea, histogramFun(arr));
        }
        System.out.println(maxArea);
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
