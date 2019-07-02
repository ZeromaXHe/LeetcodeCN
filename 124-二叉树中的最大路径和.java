//执行用时 :255 ms, 在所有 Java 提交中击败了5.04%的用户
//内存消耗 :44.5 MB, 在所有 Java 提交中击败了31.46%的用户
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
    public int maxPathSum(TreeNode root) {
        if(root==null) return -999999999;
        else return Math.max(
            maxDownPathSum(root.left)+maxDownPathSum(root.right)+root.val,//这里会重复计算，所以特别慢
            Math.max(maxPathSum(root.left), maxPathSum(root.right))
        );
    }
    private int maxDownPathSum(TreeNode root){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return root.val>0?root.val:0;
        if(root.left==null) {
            int max = maxDownPathSum(root.right);
            return max+root.val>0?max+root.val:0;
        }
        if(root.right==null) {
            int max = maxDownPathSum(root.left);
            return max+root.val>0?max+root.val:0;
        }
        else {
            int max = Math.max(maxDownPathSum(root.left),maxDownPathSum(root.right));
            return (max+root.val>0)?max+root.val:0;
        }
    }
}