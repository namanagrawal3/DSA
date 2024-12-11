package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_K_Sorted_Lists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override                               // min-Heap
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });

            for (ListNode head : lists) {
                if (head != null)
                    pq.add(head);
            }

            ListNode head = new ListNode();
            ListNode temp = head;

            while (!pq.isEmpty()) {                     // Time Complexity: O(kn * log(k))
                ListNode rv = pq.poll();
                temp.next = rv;
                temp = temp.next;

                if (rv.next != null)
                    pq.add(rv.next);
            }

            return head.next;
        }
    }
}
