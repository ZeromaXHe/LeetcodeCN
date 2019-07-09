//执行用时 :1 ms, 在所有 Java 提交中击败了99.23%的用户
//内存消耗 :37.9 MB, 在所有 Java 提交中击败了77.63%的用户
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head!=null&&head.next!=null){
            ListNode p = head.next.next;
            ListNode end1 = head;
            ListNode start2 = head.next;
            ListNode end2 = head.next;
            ListNode temp = null;
            while(p!=null){
                end1.next=p;
                temp = p.next;
                p.next = start2;
                end1=p;
                p = temp;
                end2.next=null;
                if(p!=null) {
                    end2.next=p;
                    temp = p.next;
                    p.next = null;
                    end2=p;
                    p = temp;
                }
                else break;
            }
        }
        return head;
    }
}