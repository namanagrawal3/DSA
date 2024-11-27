package Arrays;

public class Trapping_Rain_Water {
    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int n = height.length;

        int[] pre = new int[n];                                   // Prefix-Suffix Concept
        int[] suf = new int[n];

        pre[0] = height[0];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i-1], height[i]);
        }

        suf[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            suf[i] = Math.max(suf[i+1], height[i]);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(pre[i], suf[i]) - height[i];
        }

        System.out.println(sum);
    }
}
