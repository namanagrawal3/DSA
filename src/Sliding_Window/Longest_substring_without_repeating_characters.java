package Sliding_Window;

import java.util.HashMap;

public class Longest_substring_without_repeating_characters {
    public static void main(String[] args) {
        String st = "pwwkew";
        System.out.println(findSubstring(st));
    }                                                             // without repeating characters means all unique characters
    public static int findSubstring(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        int max = Integer.MIN_VALUE;
        int start=-1,end=-1;
        int i=0,j=0;
        while(j<s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size() == j-i+1){
                if(j-i+1 > max){
                    max = j-i+1;
                    start = i;
                    end = j;
                }
                j++;
            }
            else if(map.size() < j-i+1){
                while (map.size() < j-i+1) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i), 0);
                    i++;
                }
                j++;
            }
        }
        System.out.println(s.substring(start,end+1));
        return max;
    }
}
