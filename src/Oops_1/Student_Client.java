package Oops_1;

public class Student_Client {
    public static void main(String[] args) {
        System.out.println("Start");
        Student s = new Student();
        System.out.println(s.name);
        System.out.println(s.age);
        s.age = 20;
        s.name = "Naman";
        System.out.println(s.name);
        System.out.println(s.age);
        s.Intro_yourself();
        // ---------------------------
        Student s1 = new Student();
        s1.name = "Kaju";
        s1.age = 10;
        s1.Intro_yourself();
        // ---------------------------
        s.Say_hey("Raju");
        // ---------------------------
        Student.Mentor_name();
    }
    static {
        System.out.println("I am a static block in Main");
    }
}
