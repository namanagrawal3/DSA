package Oops_1;

public class Person {
    private String name = "Naman";
    private int age = 20;
    public Person(){
                                                // Non-parameterized Constructor
    }
    public Person(String name,int age){
        this.name = name;                       // Parameterized Constructor
        this.age = age;
    }

    // Encapsulation
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
