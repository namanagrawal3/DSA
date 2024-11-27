package Oops_2;

public class Stack_I_Class_2 {

    /* ----------- Anonymous way to make an object of Interface (after Java 8) ------------ */
    Stack_I sc = new Stack_I() {
        @Override
        public void push(int item) {

        }

        @Override
        public int pop() {
            return 0;
        }

        @Override
        public int peek() {
            return 0;
        }
    };
}
