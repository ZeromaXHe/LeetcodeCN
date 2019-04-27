/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null||k==1) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode pos;//存下一个位置
        ListNode tmp=dummy;//用来存前一个K组的最后一个
        ListNode test=head;//下一个K组的第一个
        int i=0;
        for(i=0;i<k;i++){//初始化test的位置
       		if(test.next!=null){
       			test=test.next;
       		}
       		else{
       			test=null;
       			break;
       		}
        }
        while (test!=null){
        	pos=head.next;//记录一下下一个的位置
        	head.next=test;//第一个连向下一个K组的第一个
        	head=pos;
        	pos=pos.next;
        	while(head!=test){
        		head.next=tmp.next;
        		tmp.next=head;
        		head=pos;
        		pos=pos.next;
			}
        	for(i=0;i<k;i++){
        		if(test.next!=null){
        			test=test.next;
        			tmp=tmp.next;
        		}
        		else{
        			test=null;
        			break;
        		}
        	}
        }
        if(i==k-1){
        	if(tmp!=dummy)tmp=tmp.next;//这个tmp不往后走一个的话75/81[1,2,3,4]用例过不去，因为tmp位置不对。不加判定也不行,66/81[1,2]过不去
        	pos=head.next;//记录一下下一个的位置
        	head.next=null;//第一个连向下一个K组的第一个
        	head=pos;
        	pos=pos.next;
        	while(head!=null){
        		head.next=tmp.next;
        		tmp.next=head;
        		head=pos;
        		if(pos!=null)pos=pos.next;
        	}
        }
        return dummy.next;
    }
}