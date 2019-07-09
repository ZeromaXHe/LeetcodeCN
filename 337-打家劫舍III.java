//执行用时 :621 ms, 在所有 Java 提交中击败了39.22%的用户
//内存消耗 :45.4 MB
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
    public int rob(TreeNode root) {
        if(root==null) return 0;
        else return mayRobRoot(root);
    }
    
    private int dontRobRoot(TreeNode root){
        if(root==null) return 0;
        if(root.left == null && root.right == null) return 0;
        else if(root.left==null) return mayRobRoot(root.right);
        else if(root.right==null) return mayRobRoot(root.left);
        else return mayRobRoot(root.left)+mayRobRoot(root.right);
    }
    
    private int mayRobRoot(TreeNode root){
        if(root==null) return 0;
        if(root.left == null && root.right == null) return root.val;
        else if(root.left==null) 
            return Math.max(root.val+dontRobRoot(root.right),doRobRoot(root.right));
        else if(root.right==null) 
            return Math.max(root.val+dontRobRoot(root.left),doRobRoot(root.left));
        else return Math.max(dontRobRoot(root),doRobRoot(root));
    }
    
    private int doRobRoot(TreeNode root){
        if(root==null) return 0;
        if(root.left == null && root.right == null) return root.val;
        else if(root.left==null) return root.val+dontRobRoot(root.right);
        else if(root.right==null) return root.val+dontRobRoot(root.left);
        else return root.val+dontRobRoot(root.right)+dontRobRoot(root.left);
    }
}