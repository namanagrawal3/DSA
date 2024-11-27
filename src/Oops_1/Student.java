package Oops_1;

public class Student {
    String name;
    int age;
    public void Intro_yourself(){
        System.out.println("My name is "+this.name+" and age is "+this.age);
    }
    public void Say_hey(String name){
        System.out.println(this.name+" say hey "+name);
    }
    public static void Mentor_name(){
        System.out.println("Monu Bhaiya is our mentor");
    }
    static {
        System.out.println("I am a static block");
    }
}
