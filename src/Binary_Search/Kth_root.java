package Binary_Search;

public class Kth_root {
    public static void main(String[] args) {
        // x^k <= N
        // Find the maximum value of x which satisfies the above equation

        int n = 146;
        int k = 3;

        System.out.println(kthroot(3,146));
    }

    public static int kthroot(int k, int n) {
        int si = 0;                                         // Binary Search on answers
        int ei = n;

        while (si <= ei) {
            int mid = si + (ei-si)/2;
            int ans = (int)Math.pow(mid, k);

            if(ans <= n)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return ei;
    }
}
