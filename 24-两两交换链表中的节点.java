/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode pos;
        ListNode tmp=dummy;
        while(head!=null&&head.next!=null){
        	pos=head.next;
        	
        	tmp.next=pos;
        	head.next=pos.next;
        	pos.next=head;
        	
        	tmp=head;
        	head=tmp.next;
        }
        return dummy.next;
    }
}