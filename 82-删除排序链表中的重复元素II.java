//执行用时 : 2 ms, 在Remove Duplicates from Sorted List II的Java提交中击败了87.49% 的用户
//内存消耗 : 35 MB, 在Remove Duplicates from Sorted List II的Java提交中击败了98.93% 的用户
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
        ListNode current = head;
        boolean flag = false;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode before = dummy;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                flag = true;
                current.next = current.next.next;
            } else {
                if(flag == true){
                    before.next = current.next;
                    flag = false;
                }else{
                    before = current;
                }
                current = current.next;
            }
        }
        if(flag == true) before.next = null;
         
        return dummy.next;
    }
}