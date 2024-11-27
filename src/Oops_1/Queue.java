package Oops_1;

public class Queue {
    protected int[] data;               // by default null
    protected int front;                  // by default 0
    private int size;
    public Queue() {
        this.data = new int[5];
    }
    public Queue(int size) {
        this.data = new int[size];
    }
    public boolean isEmpty() {
        return this.size == 0;
    }
    public boolean isFull() {
        return this.size == this.data.length;
    }
    public int size() {
        return this.size;
    }
    public void enqueue(int item) throws Exception {
        if (isFull()) {
            throw new Exception("Sorry sir, your queue is Full !!");
        }
//        int idx = this.size + this.front;                                         //  Linear Queue
        int idx = (this.size + this.front) % this.data.length;                      // Circular Queue
        this.data[idx] = item;
        this.size++;
    }
    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Sorry sir, your queue is Empty !!");
        }
        int val = this.data[this.front];
//        this.front = this.front + 1;                                              // Linear Queue
        this.front = (this.front + 1) % this.data.length;                           // Circular Queue
        this.size--;
        return val;
    }
    public int getFront() throws Exception {
        if (isEmpty()) {
            throw new Exception("Sorry sir, your queue is Empty !!");
        }
        return this.data[this.front];
    }
    public void display() {
        for (int i = 0; i < this.size; i++) {
            int idx = (this.front + i) % this.data.length;
            System.out.print(this.data[idx]+" ");
        }
        System.out.println();

        // ------------ or -------------
//        for (int i = this.front; i < this.front + this.size; i++) {
//            int idx = i % this.data.length;
//            System.out.print(this.data[idx] + " ");
//        }
//        System.out.println();
    }
}
