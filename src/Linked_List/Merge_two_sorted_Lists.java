package Linked_List;

public class Merge_two_sorted_Lists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode h = new ListNode();
        ListNode temp = h;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }
            else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            temp.next = list2;                     // no need to traverse the remaining list
            return h.next;
        }
        if (list2 == null) {
            temp.next = list1;
            return h.next;
        }
        return h.next;

    }
}
