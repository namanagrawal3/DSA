package Stack_Queue;

import Oops_1.Queue;

public class Queue_Reverse {
    public static void main(String[] args) throws Exception{
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();
        reverseFun(q);
        q.display();
    }
    public static void reverseFun(Queue q) throws Exception {
        if (q.isEmpty())
            return;
        int temp = q.dequeue();
        reverseFun(q);
        q.enqueue(temp);
    }
}
