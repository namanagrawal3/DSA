package Oops_1;

public class Person_Client {
    public static void main(String[] args) throws Exception {
        Person__Encapsulation_ExceptionHandling p1 = new Person__Encapsulation_ExceptionHandling();
//        System.out.println(p1.name);
//        System.out.println(p1.age);
        System.out.println(p1.getName());
        p1.setName("Naman");
        p1.setAge(21);
        System.out.println(p1.getName());



        Person__Encapsulation_ExceptionHandling p2 = new Person__Encapsulation_ExceptionHandling("Raj",100);
//        System.out.println(p2.name);
//        System.out.println(p2.age);
        System.out.println(p2.getName());
        p2.setAge(-10);
        System.out.println(p2.getAge());

        System.out.println("Main Program Ended successfully!!");
    }
}
