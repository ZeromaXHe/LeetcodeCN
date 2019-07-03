//执行用时 :4 ms, 在所有 Java 提交中击败了56.36%的用户
//内存消耗 :46.4 MB, 在所有 Java 提交中击败了41.21%的用户
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode p=head;
        ListNode temp = head;
        while(temp.next!=null&&temp.next.next!=null){
            p=p.next;
            temp=temp.next.next;
        }
        reverse(p);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        insert(dummy, head, p);
    }
    private void reverse(ListNode dumb){
        if(dumb==null||dumb.next==null||dumb.next.next==null) return;
        ListNode p = dumb.next;
        ListNode temp = null;
        while(p!=null){
            dumb.next=p;
            p=p.next;
            dumb.next.next=temp;
            temp=dumb.next;
        }
    }
    
    private void insert(ListNode dumb, ListNode p1, ListNode p2){
        ListNode p = p2.next;
        p2.next=null;
        p2=p;
        p=dumb;
        while(p2!=null){
            p=(p.next=p1);
            p1=p1.next;
            p=(p.next=p2);
            p2=p2.next;
        }
        if(p1!=null){
            p=p.next=p1;
        }
        p.next=null;
    }
}