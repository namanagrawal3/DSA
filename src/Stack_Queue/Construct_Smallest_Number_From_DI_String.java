package Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class Construct_Smallest_Number_From_DI_String {
    public static void main(String[] args) {
        String pattern = "IDIDDIDD";        // 1 3 2 6 5 4 9 8 7

        int n = pattern.length();
        int[] ans = new int[n+1];
        int val = 1;                       // We can use the 'Stack' also to store the indices of 'D'

        for (int i = 0; i <= n; i++) {
            if (i == n || pattern.charAt(i) == 'I') {
                ans[i] = val;
                val++;

                for (int j = i-1; j >= 0; j--) {
                    if (pattern.charAt(j) == 'I')
                        break;

                    ans[j] = val;
                    val++;
                }
            }
        }

        System.out.println(Arrays.toString(ans));
    }
}
