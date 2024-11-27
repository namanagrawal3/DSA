package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams {
    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagram(arr));
    }
    public static List<List<String>> groupAnagram(String[] arr){
        HashMap<String,List<String>> map = new HashMap<>();
        for(String st:arr){
            char[] ch = st.toCharArray();
            Arrays.sort(ch);
            String sorted_st = new String(ch);
            if(!map.containsKey(sorted_st))
                map.put(sorted_st,new ArrayList<>());
            map.get(sorted_st).add(st);
        }
        return new ArrayList<>(map.values());
    }
}
