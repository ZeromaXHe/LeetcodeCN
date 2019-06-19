//执行用时 :1 ms, 在所有 Java 提交中击败了88.10%的用户
//内存消耗 :33.7 MB, 在所有 Java 提交中击败了94.31%的用户
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = null;
        ListNode p1 = dummy;
        ListNode p2 = head;
        ListNode temp = null;
        ListNode mNode = null;
        for(int i=0;i<m;i++){
            pre = p1;
            p1=p1.next;
            p2=p2.next;
        }
        mNode = p1;
        for(int i=m;i<n;i++){
            temp = p2.next;
            p2.next=p1;
            p1=p2;
            p2=temp;
        }
        mNode.next=p2;
        pre.next = p1;
        return dummy.next;
    }
}