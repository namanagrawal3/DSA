package Strings;

public class String_Compare {
    public static void main(String[] args) {
        String s1 = "Raj";
        String s2 = "rajesh";
        System.out.println(s1.compareTo(s2));               // gives the difference of the ASCII values if the character-wise mismatching
        // +ve  --> s1 > s2
        // -ve  --> s1 < s2
        // zero --> s1 == s2
        System.out.println(compareString(s1, s2));

        String s3 = "rajesh";
        String s4 = "raj";
        System.out.println(s3.compareTo(s4));               // gives the difference of the length if the string is present in another string
        System.out.println(compareString(s3, s4));

        String s5 = "kunal";
        String s6 = "komal";
        System.out.println(s5.compareTo(s6));
        System.out.println(compareString(s5, s6));
    }
    public static int compareString(String s1,String s2){
        if (s1 == s2)
            return 0;

        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return s1.charAt(i) - s2.charAt(i);
        }

        return s1.length() - s2.length();
    }
}
