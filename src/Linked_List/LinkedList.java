package Linked_List;

public class LinkedList {
    public class Node {
        int data;
        Node next;
    }
    private Node head;
    private Node tail;
    private int size;
    public void addFirst(int item) {                        // O(1)
        Node nn = new Node();
        nn.data = item;
        if (this.size == 0) {
            this.head = nn;
            this.tail = nn;
        }
        else {
            nn.next = this.head;
            this.head = nn;
        }
        this.size++;
    }
    public void display() {                                 // O(N)
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data +" --> ");
            temp = temp.next;
        }
        System.out.println(".");
    }

    public void addLast(int item) {                         // O(1)
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
    private Node getNode(int idx) throws Exception {                           // O(N)
        if (idx < 0 || idx >= size) {
            throw new Exception("Invalid index, Index Out-Of-Range!!");
        }
        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public void addAtIndex(int idx, int item) throws Exception {               // O(N)
        if (idx < 0 || idx > size) {
            throw new Exception("Invalid index, Index Out-Of-Range!!");
        }

        if (idx == 0)
            addFirst(item);
        else if (idx == size)
            addLast(item);
        else {
            Node nn = new Node();
            nn.data = item;
            Node prev = getNode(idx - 1);
            nn.next = prev.next;
            prev.next = nn;
            size++;
        }
    }
    public int getFirst() throws Exception {                                  // O(1)
        if (head == null) {
            throw new Exception("Sorry sir, your linked list is empty...!!");
        }
        return head.data;
    }
    public int getLast() throws Exception {                                   // O(1)
        if (size == 0) {
            throw new Exception("Sorry sir, your linked list is empty...!!");
        }
        return tail.data;
    }
    public int getAtIndex(int idx) throws Exception {                         // O(N)
        return getNode(idx).data;
    }
    public int removeFirst() throws Exception {                               // O(1)
        if (size == 0) {
            throw new Exception("Sorry sir, your linked list is empty...!!");
        }
        Node temp = head;
        if (size == 1) {
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            temp.next = null;
        }
        size--;
        return temp.data;
    }
    public int removeLast() throws Exception {                               // O(N)
        if (size == 0) {
            throw new Exception("Sorry sir, your linked list is empty...!!");
        }
        if (size == 1)
            return removeFirst();
        else {
            Node prev = getNode(size - 2);
            int rv = tail.data;
            tail =  prev;
            tail.next = null;
            size--;
            return rv;
        }
    }
    public int removeAtIndex(int idx) throws Exception {                   // O(N)
        if (idx < 0 || idx >= size) {
            throw new Exception("Sorry Sir, Invalid index...!!");
        }

        if (idx == 0)
            return removeFirst();
        else if (idx == size - 1)
            return removeLast();
        else {
            Node curr = getNode(idx);
            Node prev = getNode(idx - 1);
            prev.next = curr.next;
            curr.next = null;
            size--;
            return curr.data;
        }
    }
}
