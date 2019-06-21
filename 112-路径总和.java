//执行用时 :1 ms, 在所有 Java 提交中击败了98.40%的用户
//内存消耗 :37.3 MB, 在所有 Java 提交中击败了66.08%的用户
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left==null&&root.right==null) return root.val==sum;
        if(root.left==null) return hasPathSum(root.right, sum-root.val);
        else if(root.right==null) return hasPathSum(root.left,sum-root.val);
        else return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right, sum-root.val);
    }
}