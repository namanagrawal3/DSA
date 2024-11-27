package Strings;

public class String_Demo_1 {
    public static void main(String[] args) {
        String st1 = "Hello";
        String st2 = "Hello";

        String st3 = new String("Hello");
        String st4 = new String("Hello");

        System.out.println(st1 == st2);            // true
        System.out.println(st1 == st3);            // false
        System.out.println(st3 == st4);            // false

        System.out.println(st1);
        st1 = st1 + "Bye";                       // now a copy of st1 is created outside the string-pool and "Bye" is added to it outside the pool
        System.out.println(st1);

        String st = "Ram" + "Laxman";            // here although "+" operator is used with the literals still it is created inside the pool
        System.out.println(st);
    }
}
