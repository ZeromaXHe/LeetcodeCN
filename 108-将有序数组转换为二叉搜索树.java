//执行用时 :2 ms, 在所有 Java 提交中击败了68.67%的用户
//内存消耗 :38.9 MB, 在所有 Java 提交中击败了42.36%的用户
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrToBST(nums, 0, nums.length);
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