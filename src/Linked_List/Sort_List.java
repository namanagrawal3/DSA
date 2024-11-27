package Linked_List;

public class Sort_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode l1 = head;
            ListNode mid = midFun(head);                // first mid
            ListNode l2 = mid.next;
            mid.next = null;

            ListNode h1 = sortList(l1);
            ListNode h2 = sortList(l2);

            return mergeTwoLists(h1, h2);
        }
        public ListNode midFun(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode temp = dummy;

            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    temp.next = l1;
                    temp = temp.next;
                    l1 = l1.next;
                }
                else {
                    temp.next = l2;
                    temp = temp.next;
                    l2 = l2.next;
                }
            }
            if (l1 == null) {
                temp.next = l2;
                return dummy.next;
            }
            if (l2 == null) {
                temp.next = l1;
                return dummy.next;
            }
            return dummy.next;
        }
    }
}
