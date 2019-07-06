//执行用时 :1 ms, 在所有 Java 提交中击败了86.02%的用户
//内存消耗 :36.7 MB, 在所有 Java 提交中击败了53.77%的用户
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}