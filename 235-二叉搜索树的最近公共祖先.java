//执行用时 :9 ms, 在所有 Java 提交中击败了87.99%的用户
//内存消耗 :35.9 MB, 在所有 Java 提交中击败了82.54%的用户
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val&&root.val>q.val) return lowestCommonAncestor(root.left,p,q);
        if(root.val<p.val&&root.val<q.val) return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}