//执行用时 :3 ms, 在所有 Java 提交中击败了43.16%的用户
//内存消耗 :40.2 MB, 在所有 Java 提交中击败了33.45%的用户
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
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            while(stack.peek().left!=null) {
                stack.push(stack.peek().left);
            }
            while(!stack.isEmpty()){
                TreeNode p = stack.pop();
                count++;
                if(count==k) return p.val;
                if(p.right!=null) {
                    stack.push(p.right);
                    break;
                }
            }
        }
        return -1;
    }
}