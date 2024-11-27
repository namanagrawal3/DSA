package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Determine_if_two_strings_are_close {
    public static void main(String[] args) {
        String word1 = "cabbba", word2 = "abbccc";
        System.out.println(check(word1,word2));
    }
    public static boolean check(String word1, String word2){
        int n1 = word1.length();
        int n2 = word2.length();
        if(n1 != n2)
            return false;
        HashMap<Character,Integer> map_1 = new HashMap<>();
        HashMap<Character,Integer> map_2 = new HashMap<>();
        for(int i=0;i<n1;i++){
            char ch = word1.charAt(i);
            map_1.put(ch, map_1.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<n1;i++){
            char ch = word2.charAt(i);
            if(map_1.containsKey(ch))
                map_2.put(ch, map_2.getOrDefault(ch,0)+1);
            else
                return false;
        }
        ArrayList<Integer> l1 = new ArrayList<>(map_1.values());
        ArrayList<Integer> l2 = new ArrayList<>(map_2.values());
        Collections.sort(l1);
        Collections.sort(l2);
        return l1.equals(l2);
    }
}
