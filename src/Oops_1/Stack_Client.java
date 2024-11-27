package Oops_1;

public class Stack_Client {
    public static void main(String[] args) throws Exception {
        Stack s = new Stack();
//        Stack s = new Stack(6);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        System.out.println(s.pop());
        s.display();
        s.push(60);
        System.out.println(s.peek());
        s.display();
        s.push(70);
    }
}
