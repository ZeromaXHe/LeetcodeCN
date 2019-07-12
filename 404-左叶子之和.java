//执行用时 :1 ms, 在所有 Java 提交中击败了99.50%的用户
//内存消耗 :34.3 MB, 在所有 Java 提交中击败了85.36%的用户
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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null){
            if (root.right==null) return 0;
            else return sumOfLeftLeaves(root.right);
        }
        else{
            if(root.right == null) return rootIsLeftTree(root.left);
            else return rootIsLeftTree(root.left)+sumOfLeftLeaves(root.right);
        }
    }
    private int rootIsLeftTree(TreeNode root){
        if(root==null) return 0;
        if(root.left==null){
            if (root.right==null) return root.val;
            else return sumOfLeftLeaves(root.right);
        }
        else{
            if(root.right == null) return rootIsLeftTree(root.left);
            else return rootIsLeftTree(root.left)+sumOfLeftLeaves(root.right);
        }
    }
}