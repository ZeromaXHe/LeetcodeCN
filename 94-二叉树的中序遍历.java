//执行用时 :2 ms, 在所有 Java 提交中击败了53.44%的用户
//内存消耗 :34.2 MB, 在所有 Java 提交中击败了59.39%的用户
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
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        TreeNode temp = root;
        while(temp!=null || !stack.isEmpty()){
            while(temp!=null) {
                stack.push(temp);
                temp=temp.left;
            }
            temp = stack.pop();
            res.add(temp.val);
            temp = temp.right;
        }
        return res;
    }
}