//执行用时 :7 ms, 在所有 Java 提交中击败了5.14%的用户
//内存消耗 :37.3 MB, 在所有 Java 提交中击败了67.05%的用户
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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(root.right==null){
            if(root.left==null) return true;
            else if(root.left.left!=null||root.left.right!=null) return false;
            else return true;
        }
        if(root.left==null){
            if(root.right.left!=null||root.right.right!=null) return false;
            else return true;
        }
        return isBalanced(root.left)&&isBalanced(root.right)&&Math.abs(depth(root.left)-depth(root.right))<=1;
    }
    private int depth(TreeNode root){
        if(root==null) return 0;
        if(root.right==null&& root.left==null) return 1;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}