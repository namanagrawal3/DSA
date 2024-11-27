package Codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Binary_Cut {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();

            List<Integer> l = new ArrayList<>();
            l.add(-1);

            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) == '1' && s.charAt(i + 1) == '0')
                    l.add(i);
            }
            l.add(n - 1);

            int count0 = 0;
            int count1 = 0;
            int count01 = 0;
            for (int i = 0; i < l.size() - 1; i++) {
                if (s.charAt(l.get(i) + 1) == '0' && s.charAt(l.get(i + 1)) == '0')
                    count0++;
                else if (s.charAt(l.get(i) + 1) == '1' && s.charAt(l.get(i + 1)) == '1')
                    count1++;
                else
                    count01++;
            }

            int ans = count0 + count1;

            if (count01 > 1)
                ans += (count01 - 1) * 2;
            if (count01 > 0)
                ans++;

            System.out.println(ans);
        }
    }
}
