package Linked_List;

public class linkedList_Client {
    public static void main(String[] args) throws Exception {
        linkedList ll = new linkedList();

        ll.addFirst(10);
        ll.addFirst(0);
        ll.addFirst(-10);
        ll.addFirst(-20);

        ll.display();

        ll.addLast(20);
        ll.addLast(30);

        ll.display();

        ll.addAtIndex(3,40);
        ll.display();

        System.out.println(ll.getFirst());
        System.out.println(ll.getLast());
        System.out.println(ll.getAtIndex(2));

        System.out.println(ll.removeFirst());
        System.out.println(ll.removeLast());
        System.out.println(ll.removeAtIndex(2));
        ll.display();
    }
}
