package Codeforces;

import java.util.*;
public class The_Good_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            // moving forward
            int[] pre = new int[n];
            pre[0] = 1;

            for (int i = 1; i < n; i++) {
                pre[i] += pre[i - 1];
                int ones_req = (int) Math.ceil((i + 1) / (double) k);

                if (pre[i] < ones_req)
                    pre[i]++;
            }

            // moving backward
            int count = 0;
            for (int i = n - 1; i > 0; i--) {
                int ones_req = (int) Math.ceil(Math.abs(i - n) / (double) k);
                int ones_have = pre[n - 1] - pre[i - 1];

                if (count + ones_have < ones_req)
                    count++;
            }

            System.out.println(count + pre[n - 1]);
        }
    }
}
