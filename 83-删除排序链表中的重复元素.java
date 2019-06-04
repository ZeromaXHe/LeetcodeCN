//执行用时 : 2 ms, 在Remove Duplicates from Sorted List的Java提交中击败了78.38% 的用户
//内存消耗 : 46.2 MB, 在Remove Duplicates from Sorted List的Java提交中击败了5.06% 的用户
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode node = head;
        ListNode node2 = null;
        if(node.next!=null) node2 = node.next; 
        else return head;
        while(node2.next!=null){
            if(node.val==node2.val) node.next = node2.next;
            else node = node.next;
            node2 = node2.next;
        }
        if(node.val==node2.val) node.next = null;
        return dummy.next;
    }
}