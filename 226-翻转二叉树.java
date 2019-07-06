//执行用时 :1 ms, 在所有 Java 提交中击败了88.20%的用户
//内存消耗 :35.2 MB, 在所有 Java 提交中击败了38.91%的用户
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)) return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.right;
        root.right=root.left;
        root.left=temp;
        return root;
    }
}