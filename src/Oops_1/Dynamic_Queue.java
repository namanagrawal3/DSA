package Oops_1;

public class Dynamic_Queue extends Queue {
    @Override
    public void enqueue(int item) throws Exception {
        if (isFull()) {
            int[] arr = new int[2 * this.data.length];
            for (int i = 0; i < this.data.length; i++) {
                int idx = (this.front + i) % this.data.length;
                arr[i] = this.data[idx];
            }
            this.data = arr;
            this.front = 0;
        }
        super.enqueue(item);
    }

    public static void main(String[] args) throws Exception {
        Dynamic_Queue dq = new Dynamic_Queue();
        dq.enqueue(10);
        dq.enqueue(20);
        dq.enqueue(30);
        dq.enqueue(40);
        System.out.println(dq.dequeue());
        System.out.println(dq.dequeue());
        dq.enqueue(50);
        dq.enqueue(60);
        dq.enqueue(70);
        dq.enqueue(80);
        dq.display();
    }
}
