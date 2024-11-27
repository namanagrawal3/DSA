package Linked_List;

public class Middle_of_linkedList {
    class listNode {
        int data;
        listNode next;
    }
    public listNode middleNode(listNode head) {                     // Tortoise and Hare Algorithm

        listNode slow = head;
        listNode fast = head;

        while (fast != null && fast.next != null) {                 // To print the first middle in case of even length
            slow = slow.next;                                       // while (fast.next != null && fast.next.next != null)
            fast = fast.next.next;
        }
        return slow;
    }
}
