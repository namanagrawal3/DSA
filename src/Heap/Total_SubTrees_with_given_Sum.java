package Heap;
import java.util.*;

public class Total_SubTrees_with_given_Sum {
    static class Pair {
        int sum = 0;
        int cnt = 0;
        public Pair(){

        }
        public Pair(int s, int c) {
            sum = s;
            cnt = c;
        }
    }
    public static void main(String[] args) {
        // https://codeskiller.codingblocks.com/problems/1600

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();  // Consume the newline after reading `t`
        while (t-- > 0) {
            // since, we are given a 'CBT'
            // thus, we can solve the que without creating the tree

            String[] trr = sc.nextLine().split(" ");

            int n = trr.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(trr[i]);
            }

            int x = sc.nextInt();
            sc.nextLine();  // Consume the newline after reading `x`
            System.out.println(sumFun(arr, 0, x).cnt);
        }
    }
    public static Pair sumFun(int[] arr, int pi, int x) {
        if (pi >= arr.length)
            return new Pair();

        Pair left = sumFun(arr, 2*pi + 1, x);
        Pair right = sumFun(arr, 2*pi + 2, x);

        int currSum = left.sum + arr[pi] + right.sum;
        int currCnt = left.cnt + right.cnt;
        if (currSum == x)
            currCnt++;

        return new Pair(currSum, currCnt);
    }
}
