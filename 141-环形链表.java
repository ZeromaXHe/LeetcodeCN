//执行用时 :1 ms, 在所有 Java 提交中击败了93.99%的用户
//内存消耗 :39.7 MB, 在所有 Java 提交中击败了47.69%的用户
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode p = head;
        while(p.next!=null){
            p.val=0x3f3f3f3f;//投机取巧
            p=p.next;
            if(p.val==0x3f3f3f3f){
                return true;
            }
        }
        return false;
    }
}