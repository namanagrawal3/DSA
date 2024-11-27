package Oops_1;

public class Stack_using_Queue {                                // Push Efficient [push -> O(1) , pop -> O(N)]
    private Dynamic_Queue q;

    public Stack_using_Queue() {
        q = new Dynamic_Queue();
    }
    public int size() {
        return this.q.size();
    }
    public boolean isEmpty() {
        return this.q.isEmpty();
    }
    public void push(int item) throws Exception {                   // O(1)
        q.enqueue(item);
    }
    public int pop() throws Exception {                             // O(N)
        Dynamic_Queue hlp = new Dynamic_Queue();
        while (q.size() > 1) {
            hlp.enqueue(q.dequeue());
        }
        int val = q.dequeue();
        while (hlp.size() > 0) {
            q.enqueue(hlp.dequeue());
        }
        return val;
    }
    public int peek() throws Exception {
        Dynamic_Queue hlp = new Dynamic_Queue();
        while (q.size() > 1) {
            hlp.enqueue(q.dequeue());
        }
        int val = q.dequeue();
        hlp.enqueue(val);
        while (hlp.size() > 0) {
            q.enqueue(hlp.dequeue());
        }
        return val;
    }

    public static void main(String[] args) throws Exception {
        Stack_using_Queue st = new Stack_using_Queue();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);
        System.out.println(st.pop());
        System.out.println(st.peek());
    }
}
