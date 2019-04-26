/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode head;

        ListNode temp;
        ListNode pos1 = l1;
        ListNode pos2 = l2;
        ListNode now;
        if(pos1.val>pos2.val) {
        	now=head=l2;
        	pos2=pos2.next;
        }
        else if(pos1.val<pos2.val){
        	now=head=l1;
        	pos1=pos1.next;
        }else{
        	head=l1;
        	now=l2;
        	pos1=pos1.next;
        	pos2=pos2.next;
        	head.next=now;
        }
        
        while(pos1!=null&&pos2!=null){
        	if(pos1.val>pos2.val){
        		temp=pos2;
        		pos2=pos2.next;
        		now.next=temp;
        		now=temp;
        	}else if(pos2.val>pos1.val){
       			temp=pos1;
        		pos1=pos1.next;
        		now.next=temp;
        		now=temp;
       		}else{
       			temp=pos2;
        		pos2=pos2.next;
        		now.next=temp;
        		now=temp;
        		temp=pos1;
        		pos1=pos1.next;
        		now.next=temp;
        		now=temp;
       		}
        }
        if(pos1!=null){
        	now.next=pos1;
        }
        if(pos2!=null){
        	now.next=pos2;
        }
        return head;
    }
}