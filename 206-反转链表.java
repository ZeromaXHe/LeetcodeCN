//执行用时 :1 ms, 在所有 Java 提交中击败了84.75%的用户
//内存消耗 :36.4 MB, 在所有 Java 提交中击败了55.76%的用户
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode pre = head;
        ListNode now = head.next;
        ListNode post = now.next;
        head.next=null;
        while(now!=null){
            now.next=pre;
            pre=now;
            now=post;
            if(post!=null) post=post.next;
        }
        return pre;
    }
}