package Sliding_Window;

import java.util.HashMap;

public class Longest_substring_with_K_unique_characters {
    public static void main(String[] args) {
        String st = "aabacbebebe";
        int k = 3;
        System.out.println(findSubstring(st,k));
    }
    public static int findSubstring(String s,int k){
        HashMap<Character,Integer> map=new HashMap<>();
        int max = Integer.MIN_VALUE;
        int start=-1,end=-1;
        int i=0,j=0;
        while(j<s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size() < k)
                j++;
            else if(map.size() == k){
                if(j-i+1 > max){
                    max = j-i+1;
                    start = i;
                    end = j;
                }
                j++;
            }
            else {
                while (map.size() > k) {
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
