package Oops_1;

public class Person__Encapsulation_ExceptionHandling {
    private String name;
    private int age;
    public Person__Encapsulation_ExceptionHandling() {
                                                // Non-parameterized Constructor
    }
    public Person__Encapsulation_ExceptionHandling(String name, int age) {
        this.name = name;                       // Parameterized Constructor
        this.age = age;
    }

    // Encapsulation (Data-Hiding for Security Purposes)
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
//    public void setAge(int age) throws Exception{
////        if (age < 0)
////            return;
//
//        if (age < 0)
//            throw new Exception("Age can't be negative!!");
//        this.age = age;
//    }
    public void setAge(int age) {
        try {
            if (age < 0)
                throw new Exception("Age can't be negative!!");
            this.age = age;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Exception has occured!!");
        }
    }
    public int getAge() {
        return this.age;
    }
}
