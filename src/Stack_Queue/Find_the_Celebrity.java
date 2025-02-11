package Stack_Queue;

import java.util.*;

public class Find_the_Celebrity {
    public static void main(String[] args) {
        int[][] mat = {{0,1,1,1},{1,0,1,1},{0,0,0,0},{1,1,1,0}};

        System.out.println(n2_Approach(mat));
        System.out.println(n_Approach(mat));
    }
    public static int n2_Approach(int[][] mat) {
        int n = mat.length;
        int[] inDeg = new int[n];
        int[] outDeg = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    inDeg[j]++;
                    outDeg[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (inDeg[i] == n-1 && outDeg[i] == 0)
                return i;
        }

        return -1;
    }
    public static int n_Approach(int[][] mat) {
        int n = mat.length;
        Stack<Integer> st = new Stack();        //stores the valid celebrity
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if (mat[a][b] == 1)
                st.push(b);
            else
                st.push(a);
        }

        int celeb = st.pop();
        for (int i = 0; i < n; i++) {
            if (i == celeb)
                continue;
            if (mat[i][celeb] == 0 || mat[celeb][i] == 1)
                return -1;
        }

        return celeb;
    }
}
