package Strings;

public class String_Equals {
    public static void main(String[] args) {
        String s = "HelloBye";
        System.out.println(s.length());            // It is a method in String class, while a variable in Array class
        System.out.println(s.charAt(5));

        String s1 = "hello";
        String s2 = new String("hello");

        System.out.println(s1.equals(s2));
        System.out.println(equalString(s1, s2));
        System.out.println(equalString("hello", "heleo"));
    }
    public static boolean equalString(String st1, String st2) {
        if (st1 == st2)
            return true;

        if (st1.length() != st2.length())
            return false;

        for (int i = 0; i < st1.length(); i++) {
            if (st1.charAt(i) != st2.charAt(i))
                return false;
        }
        return true;
    }
}
