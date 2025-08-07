package Sliding_Window;

import java.util.HashMap;

public class Minimum_Window_Substring {
    public static void main(String[] args) {
        String s1 = "timetopractice", s2 = "toc";

        int l1 = s1.length();
        int l2 = s2.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < l2; i++) {
            char ch = s2.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int start = -1;
        int minLen = Integer.MAX_VALUE;
        int si = 0, ei = 0;
        int count = map.size();

        while (ei < l1) {
            char ch = s1.charAt(ei);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0)
                    count--;
            }

            while (count == 0 && si <= ei) {
                if ((ei-si+1) < minLen) {
                    minLen = ei-si+1;
                    start = si;
                }

                char sch = s1.charAt(si);
                if (map.containsKey(sch)) {
                    map.put(sch, map.get(sch) + 1);
                    if (map.get(sch) == 1)
                        count++;
                }
                si++;
            }

            ei++;
        }

        if (start == -1)
            return;
        System.out.println(s1.substring(start, start + minLen));
    }
}
