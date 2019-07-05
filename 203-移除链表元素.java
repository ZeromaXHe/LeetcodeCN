//执行用时 :2 ms, 在所有 Java 提交中击败了95.22%的用户
//内存消耗 :43.7 MB, 在所有 Java 提交中击败了64.67%的用户
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode now = head;
        while(now!=null){
            if(now.val==val) pre.next=now.next;
            else pre=pre.next;
            now=now.next;
        }
        return dummy.next;
    }
}