package Linked_List;

public class Cycle_in_linkedList {
    public class Node {
        int data;
        Node next;
    }
    private Node head;
    private Node tail;
    private int size;
    public void addFirst(int item) {                                     // O(1)
        Node nn = new Node();
        nn.data = item;
        if (this.size == 0) {
            this.head = nn;
            this.tail = nn;
            this.size++;
        }
        else {
            nn.next = this.head;
            this.head = nn;
            this.size++;
        }
    }
    public void display() {                                             // O(N)
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data +" --> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public void addLast(int item) {                                     // O(1)
        if (size == 0) {
            addFirst(item);
        }
        else {
            Node nn = new Node();
            nn.data = item;
            tail.next = nn;
            tail = nn;
            size++;
        }
    }
    private Node getNode(int idx) throws Exception {                    // O(N)
        if (idx < 0 || idx >= size) {
            throw new Exception("Sorry Sir, Invalid index...!!");
        }
        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public void createCycle() throws Exception {
        Node nn = getNode(2);
        tail.next = nn;
    }
    public Node hasCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return slow;
        }
        return null;
    }
    public void removeCycle1() {                                         // O(N^2)
        Node meet = hasCycle();
        if (meet == null)
            return;
        Node start = head;
        while (start != null) {
            Node temp = meet;
            while (temp.next != meet) {
                if (temp.next == start) {
                    temp.next = null;
                    return;
                }
                temp = temp.next;
            }
            start = start.next;
        }
    }
    public void removeCycle2() {                                          // O(N)
        Node meet = hasCycle();
        if (meet == null)
            return;

        // length of cycle
        int count = 1;
        Node temp = meet;
        while (temp.next != meet) {
            count++;
            temp = temp.next;
        }

        // fast ko 'count' ahead move kar denge
        Node fast = head;
        for (int i = 0; i < count; i++) {
            fast = fast.next;
        }
        // fast and slow ko move karo
        Node slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }
    public void floyedCycleRemoval() {
        Node meet = hasCycle();
        if (meet == null)
            return;

        Node fast = meet;
        Node slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }

    public static void main(String[] args) throws Exception {
        Cycle_in_linkedList cl = new Cycle_in_linkedList();

        cl.addLast(10);
        cl.addLast(20);
        cl.addLast(30);
        cl.addLast(40);
        cl.addLast(50);
        cl.addLast(60);
        cl.addLast(70);
        cl.addLast(80);
//        cl.display();

        cl.createCycle();
        cl.display();
    }
}
