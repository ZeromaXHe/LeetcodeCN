//执行用时 :4 ms, 在所有 Java 提交中击败了25.07%的用户
//内存消耗 :35.1 MB, 在所有 Java 提交中击败了18.23%的用户
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
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        LinkedList<Integer> ll = new LinkedList();
        ListNode p = head;
        while(p.next!=null){
            ll.add(p.val);
            p.val=0x3f3f3f3f;//投机取巧
            p=p.next;
            if(p.val==0x3f3f3f3f){
                ListNode p2 = head;
                while(p2!=p) {
                    p2.val = ll.removeLast();
                    p2=p2.next;
                }
                if(p2==p){
                    p2.val = ll.removeLast(); 
                    p2=p2.next;
                }
                while(p2!=p) {
                    p2.val = ll.removeLast();
                    p2=p2.next;
                }
                return p;
            }
        }
        return null;
    }
}