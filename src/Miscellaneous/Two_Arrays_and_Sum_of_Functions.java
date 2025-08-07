package Miscellaneous;
import java.util.*;

public class Two_Arrays_and_Sum_of_Functions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            long ai = sc.nextLong();
            arr[i] = ai * (i+1) * (n-i);
        }

        Integer[] brr = new Integer[n];
        for (int i = 0; i < n; i++) {
            brr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        Arrays.sort(brr, Collections.reverseOrder());

        long ans = 0;
        int mod = 998244353;
        for (int i = 0; i < n; i++) {
            ans = (ans + (arr[i] % mod * brr[i])) % mod;
        }

        System.out.println(ans);
    }
}
