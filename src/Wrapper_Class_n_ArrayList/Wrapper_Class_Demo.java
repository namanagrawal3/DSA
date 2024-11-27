package Wrapper_Class_n_ArrayList;

public class Wrapper_Class_Demo {
    public static void main(String[] args) {
        int a1 = 20;
        Integer a2 = 10;

        System.out.println(a1);
        System.out.println(a2);

        // Auto-Boxing  -->  transferring the content of primitive datatype to non-primitive wrapper class
        int b1 = 9;
        Integer b2 = 90;
        b2 = b1;

        // Un-Boxing    -->  transferring the content of non-primitive wrapper class to primitive datatype
        Integer c1 = 89;
        int c2 = -6;
        c2 = c1;

        Integer d1 = 78;
        Integer d2 = 78;
        Integer d3 = 178;
        Integer d4 = 178;
        System.out.println(d1 == d2);           // same address is alloted to both inside the Integer-Cache array (in Heap Memory)
        System.out.println(d3 == d4);           // different addresses are alloted in the Heap Memory (outside the cache array)
    }
}
