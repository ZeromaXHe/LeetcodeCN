//执行用时 :2 ms, 在所有Java提交中击败了96.09%的用户
//内存消耗 :48.2 MB, 在所有Java提交中击败了5.97%的用户
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode pa = headA;
        ListNode pb = headB;
        if(pa==null||pb==null) return null;
        int lenA = 1;
        int lenB = 1;
        while(pa.next!=null){
            lenA++;
            pa=pa.next;
        }
        while(pb.next!=null){
            lenB++;
            pb=pb.next;
        }
        pa=headA;
        pb=headB;
        if(lenA>lenB){
            for(int i=0;i<lenA-lenB;i++){
                pa=pa.next;
            }
        }
        else{
            for(int i=0;i<lenB-lenA;i++){
                pb=pb.next;
            }
        }
        while(pa!=pb){
            pa=pa.next;
            pb=pb.next;
        }
        return pa;
    }
}