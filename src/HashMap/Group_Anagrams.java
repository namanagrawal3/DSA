package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        HashMap<String , List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (String s : strs) {
            String key = keyFun(s);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }

        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }

        System.out.println(ans);
    }
    public static String keyFun(String s) {
        int[] fre = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            fre[s.charAt(i)-'a']++;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            ans.append(fre[i]);
            ans.append(',');
        }
        return ans.toString();
    }
}
