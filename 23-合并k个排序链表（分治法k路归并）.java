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
        return kMergeSort(lists, 0, lists.length - 1);
    }
    
    private ListNode kMergeSort(ListNode[] lists, int start, int end) {
        if (start >= end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = kMergeSort(lists, start, mid);
        ListNode right = kMergeSort(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        
        ListNode head = new ListNode(-1);
        // pIter始终指向新节点
        ListNode pIter = head;
        ListNode p1 = left, p2 = right;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                pIter.val = p1.val;
                p1 = p1.next;
            } else {
                pIter.val = p2.val;
                p2 = p2.next;
            }
            ListNode pNew = new ListNode(-1);
            pIter.next = pNew;
            pIter = pIter.next;
        }
        while (p1 != null) {
            pIter.val = p1.val;
            if (p1.next != null) {
                ListNode pNew = new ListNode(-1);
                pIter.next = pNew;
                pIter = pIter.next;
            }
            p1 = p1.next;
        }
        while (p2 != null) {
            pIter.val = p2.val;
            if (p2.next != null) {
                ListNode pNew = new ListNode(-1);
                pIter.next = pNew;
                pIter = pIter.next;
            }
            p2 = p2.next;
        }
        return head;
    }    
}