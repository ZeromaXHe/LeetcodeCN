//执行用时 :36 ms, 在所有 Java 提交中击败了56.96%的用户
//内存消耗 :38 MB, 在所有 Java 提交中击败了63.92%的用户
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode comp = dummy;
        ListNode p = head.next;
        ListNode temp = head;
        temp.next=null;
        //System.out.println("Start...");
        while(p!=null){
            while(comp.next!=null&&comp.next.val<p.val){
                comp=comp.next;
                //System.out.println("comp:"+comp.val);
            }
            temp=comp.next;
            comp.next=p;
            p=p.next;
            comp.next.next = temp;
            comp=dummy;
            // ListNode scan = dummy.next;
            // System.out.print('[');
            // while(scan!=null){
            //     System.out.print(scan.val);
            //     if(scan.next!=null)System.out.print(',');
            //     scan=scan.next;
            // }
            // System.out.println(']');
        }
        return dummy.next;
    }
}