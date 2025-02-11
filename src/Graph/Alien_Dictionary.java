package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Alien_Dictionary {
    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftta"};

        System.out.println(alienFun(words));
    }
    public static String alienFun(String[] words) {
        int n = words.length;
        int[] inDeg = new int[26];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            if (w1.length() != w2.length() && w1.startsWith(w2))              // Ex:  {abcd, ab}
                return "";

            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char ch1 = w1.charAt(j);
                char ch2 = w2.charAt(j);
                if (ch1 == ch2)
                    continue;

                inDeg[ch2-'a']++;
                adj.get(ch1-'a').add(ch2-'a');
                break;
            }
        }

        boolean[] occur = new boolean[26];
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                occur[ch-'a'] = true;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (occur[i] && inDeg[i] == 0)
                q.add(i);
            if (occur[i])
                cnt++;
        }

        while (!q.isEmpty()) {
            int rv = q.poll();
            ans.append((char)('a'+ rv));
            cnt--;

            for (int nbr : adj.get(rv)) {
                inDeg[nbr]--;
                if (inDeg[nbr] == 0)
                    q.add(nbr);
            }
        }

        if (cnt != 0)
            return "";
        return ans.toString();
    }
}
