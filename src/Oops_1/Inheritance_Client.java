package Oops_1;

public class Inheritance_Client {
    public static void main(String[] args) {
//        // ******* Case-1 (no Inheritance) *******
//        Inheritance_Parent p = new Inheritance_Parent();
//        System.out.println(p.d2);
//        p.fun2();



        // ******* Case-2 (Inheritance - mostly used) *******
        Inheritance_Parent p = new Inheritance_Child();
        System.out.println(p.d);                           // Common data member will be fetched according to the reference variable (LHS)
        System.out.println(p.d2);

//        System.out.println(p.d1);                        // At compile-time, compiler knows only the LHS part (ie, parent class object members)
        // Thus, we will typecast the object as child (since it was creating the problem only during the compile-time, at run-time JVM will know about the child object)
        System.out.println(((Inheritance_Child)(p)).d1);
        System.out.println(((Inheritance_Child)(p)).d);    // Typecast to get the value of Child class in case of Common Variables also

        p.fun();                                           // In case of common functions, run-time object function will get called ie, RHS (not LHS)
        p.fun2();
//        p.fun1();
        ((Inheritance_Child)(p)).fun1();
        ((Inheritance_Parent)(p)).fun();                   // After typecasting to parent also, child's overrided method gets called



        // ******* Case-3 (not possible in Java) *******
//        Inheritance_Child c = new Inheritance_Parent();
//        System.out.println(c.d);
//        System.out.println(c.d1);
//        System.out.println(c.d2);

        // Here, child class object can access both itself and parent's data members at compile-time,
        // but at run-time, object of parent class will get created which don't have access to child's data members
        // so to avoid run-time error, it gives the error during the compile-time (thus, not possible in java)

        // "Although error is not good but Compile-time error is always better than Run-time error !!"



        // ******* Case-4 (Inheritance) *******
        Inheritance_Child c = new Inheritance_Child();
        System.out.println(c.d);                           // Common data will be fetched according to the reference variable (LHS)
        System.out.println(((Inheritance_Parent)(c)).d);
        System.out.println(c.d1);
        System.out.println(c.d2);

        c.fun();
        ((Inheritance_Parent)(c)).fun();                   // After typecasting to parent also, child's method (overrided) is called
        c.fun1();
        c.fun2();
    }
}
