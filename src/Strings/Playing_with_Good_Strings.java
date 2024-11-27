package Strings;

public class Playing_with_Good_Strings {
    public static void main(String[] args) {
        // print length of the longest substring containing only vowels

        String s = "cbaeicde";
        int n = s.length();

        int maxLen = Integer.MIN_VALUE;
        int count = 0;                                                  // Approach-2: Sliding Window

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch))
                count++;
            else{
                maxLen = Math.max(maxLen, count);
                count = 0;
            }
        }

        System.out.print(Math.max(maxLen, count));
    }
    public static boolean isVowel(char ch) {
        if (ch =='a' || ch =='e' || ch =='i' || ch =='o' || ch =='u')
            return true;
        return false;
    }
}
