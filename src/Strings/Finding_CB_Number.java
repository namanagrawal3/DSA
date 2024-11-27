package Strings;

import java.util.Scanner;

public class Finding_CB_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();

        System.out.println(countCbNumber(str));
    }
    public static boolean isCbNumber(long n) {
        if (n <= 1)
            return false;

        int[] arr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        for (int i = 0; i < arr.length; i++) {
            if (n == arr[i])
                return true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (n % arr[i] == 0)
                return false;
        }
        return true;
    }
    public static int countCbNumber(String str) {
        int count = 0;
        int n = str.length();
        boolean[] visited = new boolean[n];

        for (int len = 1; len <= n; len++) {
            for (int j = len; j <= n; j++) {
                int i = j - len;
                String s = str.substring(i, j);

                if (isCbNumber(Long.parseLong(s)) && isVisited(visited,i,j-1)) {
                    count++;
                    for (int k = i; k <= j-1; k++) {
                        visited[k] = true;
                    }
                }
            }
        }

        return count;
    }
    public static boolean isVisited(boolean[] visited, int si, int ei) {
        for (int i = si; i <= ei; i++) {
            if (visited[i] == true)
                return false;
        }
        return true;
    }
}
