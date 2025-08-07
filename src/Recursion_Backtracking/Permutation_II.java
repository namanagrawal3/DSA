package Recursion_Backtracking;

import java.util.Arrays;

public class Permutation_II {
    public static void main(String[] args) {
        String st = "aba";
        printPermutation(st,"");

        System.out.println();
        uniquePermutation(st,"");

        System.out.println();
        char[] arr = st.toCharArray();
        boolean[] visited = new boolean[arr.length];
        Arrays.sort(arr);
        optimizedUnique(arr, visited, new StringBuilder());
    }
    public static void printPermutation(String que, String ans) {
        if (que.length() == 0) {
            System.out.print(ans+" ");
            return;
        }

        for (int i = 0; i < que.length(); i++) {
            char ch = que.charAt(i);
            String Que = que.substring(0, i) + que.substring(i+1);
            printPermutation(Que,ans + ch);
        }
    }
    public static void uniquePermutation(String que, String ans) {
        if (que.length() == 0) {
            System.out.print(ans+" ");
            return;
        }

        for(int i=0;i<que.length();i++){
            char ch = que.charAt(i);
            boolean flag = true;
            for(int j=i+1;j<que.length();j++){
                if(que.charAt(j) == ch){
                    flag = false;
                    break;
                }
            }
            if(flag){
                String QUE = que.substring(0,i) + que.substring(i+1);
                uniquePermutation(QUE,ans+ch);
            }
        }
    }
    public static void optimizedUnique(char[] arr, boolean[] visited, StringBuilder ans) {
        if (ans.length() == arr.length) {
            System.out.print(ans+ " ");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i])
                continue;
            if (i > 0 && arr[i] == arr[i-1] && !visited[i-1])
                continue;

            visited[i] = true;
            ans.append(arr[i]);
            optimizedUnique(arr, visited, ans);
            visited[i] = false;
            ans.setLength(ans.length()-1);
        }
    }
}
