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
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        ArrayList<ListNode> al = new ArrayList<>();
        
        for (ListNode head : lists) {
            while (head != null) {
                al.add(head);
                head=head.next;
            }
        }
        al.sort(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val==o2.val)return 0;
                else return o1.val < o2.val ? -1 : 1;
            }
        });
        ListNode head = new ListNode(-1);
        if(al.size()!=0){
            head.next=al.get(0);
            int pIter = 1;

            while (pIter<al.size()) {
                al.get(pIter-1).next=al.get(pIter);
                pIter++;
            }
        }
        head = head.next;
        return head;
    }    
}