/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k=lists.length;
        ListNode[] heap=new ListNode[2*k-1];
        ListNode tmp;
        ListNode dummy=new ListNode(0);
        ListNode ans=dummy;
        ListNode pos=dummy;
        int temp;
        
        for(int i=0;i<2*k-1;i++){
        	temp=i;
        	if(lists[i%k]!=null){
        		heap[temp]=lists[i%k];
        		lists[i%k]=lists[i%k].next;
        	}
        	else{
        		int test=(i+1)%k;
        		while(test!=i%k){
        			if(lists[test]!=null){
        				heap[temp]=lists[i%k];
        				lists[i%k]=lists[i%k].next;
        				break;
        			}
        			else{
        				test=(test+1)%k;
        			}
        		}
        		break;//说明初始化时最小堆都填不满
        	}
        	while(temp!=0&&heap[(temp-1)/2].val>heap[temp].val){
        		tmp=heap[(temp-1)/2];
        		heap[(temp-1)/2]=heap[temp];
        		heap[temp]=tmp;
        		temp=(temp-1)/2;
        	}
        }
        while(heap[0]!=null){
        	pos.next=heap[0];
        	pos=pos.next;

        	heap[0]=null;
        	for(int i=2*k-2;i>0;i--){
        		if(heap[i]!=null){
        			if(i>=k-1){
        				heap[0]=heap[i];
        				temp=2*k-2-i;
        				if(lists[temp]!=null){
        					heap[i]=lists[temp];
        					lists[temp]=lists[temp].next;
        				}
        				else{
        					heap[i]=null;
        				}
        			}
        			else{
        				heap[0]=heap[i];
        				heap[i]=null;
        			}
        			temp=0;
        			//重新排最小堆这里肯定有大问题。。。
        			while((temp*2+1<2*k-1&&heap[temp*2+1]!=null &&heap[temp].val>heap[temp*2+1].val)||(temp*2+2<2*k-1&&heap[temp*2+2]!=null&&heap[temp].val>heap[temp*2+2].val)){//利用||和&&短路性质
        				if(heap[temp].val>heap[temp*2+1].val){
        					tmp=heap[temp];
        					heap[temp]=heap[temp*2+1];
        					heap[temp*2+1]=tmp;
        					temp=temp*2+1;
        				}
        				else{
        					tmp=heap[temp];
        					heap[temp]=heap[temp*2+2];
        					heap[temp*2+2]=tmp;
        					temp=temp*2+2;
        				}
        			}
        		}
        	}

        }
        return ans.next;
    }
}
// 1	1
// 2	3
// 3	5
// 4	7
// 5	9
		