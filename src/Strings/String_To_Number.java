package Strings;

public class String_To_Number {
    public static void main(String[] args) {
        String str = "234678885";

        int x = Integer.parseInt(str);                // Maximum length is 9 for integer
        System.out.println(x);

        long y = Long.parseLong(str);
        System.out.println(y);
    }
}
