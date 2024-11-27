package Codeforces;

import java.util.Scanner;

public class Inhabitant_of_the_deep_sea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(fun(arr,k));
        }
    }
    public static int fun(int[] arr, long k) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        long frontAttacks = (k % 2 == 0) ? k/2 : k/2 + 1;
        long endAttacks = k - frontAttacks;
        while (i < n && frontAttacks > 0) {
            if (arr[i] <= frontAttacks) {
                frontAttacks -= arr[i];
                i++;
            }
            else {
                arr[i] -= frontAttacks;
                break;
            }
        }
        if (i == n)
            return n;
        while (j >= i && endAttacks > 0) {
            if (arr[j] <= endAttacks) {
                endAttacks -= arr[j];
                j--;
            }
            else {
                arr[j] -= endAttacks;
                break;
            }
        }
        return n - (j-i+1);
    }
}
