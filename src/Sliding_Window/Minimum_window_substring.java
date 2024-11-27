package Sliding_Window;

import java.util.HashMap;

public class Minimum_window_substring {
    public static void main(String[] args) {
        //String s = "ADOBECODEBANC";
        //String t = "ABC";
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int count = map.size();
        int i=0,j=0;
        int min = Integer.MAX_VALUE;
        int start = -1,end = -1;
        while(j < s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0)
                    count--;
            }
            while(count == 0){
                if(min > j-i+1){
                    min = j-i+1;
                    start = i;
                    end = j;
                }
                char ch2 = s.charAt(i);
                if(map.containsKey(ch2)) {
                    map.put(ch2, map.get(ch2) + 1);
                    if(map.get(ch2) > 0)
                        count++;
                }
                i++;
            }
            j++;
        }
        System.out.println(s.substring(start,end+1));
    }
}
