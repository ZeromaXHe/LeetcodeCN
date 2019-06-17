//执行用时 :2 ms, 在所有Java提交中击败了97.90%的用户
//内存消耗 :35.5 MB, 在所有Java提交中击败了84.12%的用户

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0) return head;
        ListNode ptr = head;
        int len = 1;
        while(ptr.next!=null){
            ptr=ptr.next;
            len++;
        }
        if(k%len==0) return head;
        ListNode ptr2 = head;
        for(int i=1;i<len-k%len;i++){
            ptr2=ptr2.next;
        }
        ListNode res = ptr2.next;
        ptr.next=head;
        ptr2.next = null;
        return res;
    }
}