/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);//引入哑节点防止head被删除
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i=0;i<=n;i++){
            first=first.next;//first走到second后n个节点的位置
        }
        while(first!=null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;//删除倒数第n个节点
        return dummy.next;
    }
}