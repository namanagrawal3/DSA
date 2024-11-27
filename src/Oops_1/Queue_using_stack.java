package Oops_1;

import java.util.Stack;

public class Queue_using_stack {                                        // Dequeue Efficient
    private Stack<Integer> st;
    public Queue_using_stack() {
        this.st = new Stack<>();
    }
    public int size() {
        return this.st.size();
    }
    public boolean isEmpty() {
        return this.st.isEmpty();
    }
    public void enqueue(int item) {                                     // O(N)
        Stack<Integer> hlp = new Stack<>();
        while (!st.isEmpty()) {
            hlp.push(st.pop());
        }
        st.push(item);
        while (!hlp.isEmpty()) {
            st.push(hlp.pop());
        }
    }
    public int dequeue() {                                              // O(1)
        return this.st.pop();
    }
    public int getFront() {
        return this.st.peek();
    }

    public static void main(String[] args) {
        Queue_using_stack q = new Queue_using_stack();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        System.out.println(q.dequeue());
        q.enqueue(50);
        System.out.println(q.getFront());
    }
}
