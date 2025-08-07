package Oops_1;

public class Stack {
    protected int[] data;                       // not private because it can't be inherited outside
    private int top = 0;
    public Stack() {
        this.data = new int[5];
    }
    public Stack(int size) {
        this.data = new int[size];
    }
    public boolean isEmpty() {
        return this.top == 0;                                   // O(1)
    }
    public boolean isFull() {
        return this.top == this.data.length;                    // O(1)
    }
    public void push(int item) throws Exception {
        if (isFull()) {
            throw new Exception("Element can't be added, Stack is Full!!");
        }
        this.data[this.top] = item;                             // O(1)
        this.top++;
    }
    public int pop() throws Exception {
        if (isEmpty()) {
           throw new Exception("Element can't be deleted, Stack is Empty!!");
        }
        this.top--;                                             // O(1)
        return this.data[this.top];
    }
    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack has no element!!");
        }
        return this.data[this.top-1];                           // O(1)
    }
    public int size() {
        return this.top;                                        // O(1)
    }
    public void display() {                                     // O(N)
        for (int i = 0; i < this.top; i++) {
            System.out.print(this.data[i] +" ");
        }
        System.out.println();
    }
}
