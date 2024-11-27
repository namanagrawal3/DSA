package Strings;

public class String_Demo_2 {
    public static void main(String[] args) {
        String s1 = "Hello";                            // created inside the String-Pool
        String s2 = "Bye";                              // inside pool

        String s3 = s1 + s2;                            // created outside the String-Pool (internally new keyword gets called)
        String s4 = s1 + "Naman";                       // outside the pool

        String s5 = "Good" + "Bye";                     // created inside the String-Pool (because both are literals)

        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

        System.out.println();

        System.out.println("Hey" + 10 + 20 + "Bye" + 30 + 40);              // print statement reads from left to right
        System.out.println(10 + 20 + "Hey" + "Bye" + 30 + 40);
        System.out.println("Hey" + (10 + 20) + "Bye" + 30 + 40);
    }
}
