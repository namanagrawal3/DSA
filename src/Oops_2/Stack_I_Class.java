package Oops_2;

public class Stack_I_Class implements Stack_I{

    @Override
    public void push(int item) {
        System.out.println(Stack_I.x);
//        Stack_I.x = Stack_I.x + 2;                            // variable can't be modified because of 'final' keyword
    }

    @Override
    public int pop() {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }

    public static void main(String[] args) {
        Stack_I_Class sc = new Stack_I_Class();
    }
}
