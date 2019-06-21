//执行用时 :2 ms, 在所有 Java 提交中击败了94.83%的用户
//内存消耗 :35.1 MB, 在所有 Java 提交中击败了87.22%的用户
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
    public void flatten(TreeNode root) {
        if(root==null) return;
        if(root.left==null&&root.right==null) return;
        if(root.left==null){
            flatten(root.right);
        }
        else if(root.right==null) {
            root.right=root.left; 
            root.left=null;
            flatten(root.right);
        }
        else{
            TreeNode temp = null;
            flatten(root.left);
            flatten(root.right);
            temp=root.right;
            root.right = root.left;
            root.left=null;
            while (root.right!=null) root=root.right;
            root.right = temp;
        }
    }
}