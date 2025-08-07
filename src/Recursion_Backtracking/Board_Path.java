package Recursion_Backtracking;

public class Board_Path {
    public static void main(String[] args) {
        int n = 4;

        System.out.print("\n" + jumpFun1(n,0,""));
        System.out.println();

        System.out.print("\n" + jumpFun2(n,""));

    }
    public static int jumpFun1(int end, int curr, String ans) {
        if (curr == end) {
            System.out.print(ans +" ");
            return 1;
        }
        if (curr > end)
            return 0;

        int count = 0;
        for (int jump = 1; jump <= 3; jump++) {
            count += jumpFun1(end,curr+jump,ans+jump);
        }

        return count;
    }
    public static int jumpFun2(int n, String ans) {
        if (n == 0) {
            System.out.print(ans + " ");
            return 1;
        }
        if (n < 0)
            return 0;

        int count = 0;
        for (int i = 1; i <= 3; i++) {
            count += jumpFun2(n-i, ans + i);
        }

        return count;
    }
}
