//执行用时 :3 ms, 在所有 Java 提交中击败了73.26%的用户
//内存消耗 :41.6 MB, 在所有 Java 提交中击败了36.64%的用户
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int[] nums = listToArr(head);
        return arrToBST(nums,0,nums.length);
    }
    private int[] listToArr(ListNode head){
        if(head==null) return new int[0];
        int count = 0;
        ListNode p = head;
        while(p.next!=null){
            p=p.next;
            count++;
        }
        count++;
        int[] nums = new int[count];
        p=head;
        count=0;
        nums[count] = p.val;
        while(p.next!=null){
            p=p.next;
            count++;
            nums[count] = p.val;
        }
        return nums;
    }
    private TreeNode arrToBST(int[] nums, int start,int len){
        if(len==0) return null;
        TreeNode res = new TreeNode(nums[start+len/2]);
        if(len>1){
            res.left = arrToBST(nums, start, len/2);
            res.right = arrToBST(nums, start+len/2+1,len-len/2-1);
        }
        return res;
    }
}