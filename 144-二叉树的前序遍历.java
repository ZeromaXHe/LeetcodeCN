//执行用时 :2 ms, 在所有 Java 提交中击败了58.98%的用户
//内存消耗 :35.3 MB, 在所有 Java 提交中击败了40.72%的用户
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
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root==null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode p = stack.peek();
            res.add(p.val);
            stack.pop();
            if(p.right!=null) stack.push(p.right);
            if(p.left!=null) stack.push(p.left);
        }
        return res;
    }
}