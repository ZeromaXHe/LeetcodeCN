/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val < o2.val ? -1 : 1;
            }
        });
        
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode pIter = head;
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            if (min.next != null) {
                pq.offer(min.next);
            }
            ListNode pNew = new ListNode(min.val);
            pIter.next = pNew;
            pIter = pIter.next;
        }
        head = head.next;
        return head;
    }    
}