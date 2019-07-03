//执行用时 :1 ms, 在所有 Java 提交中击败了99.65%的用户
//内存消耗 :34.9 MB, 在所有 Java 提交中击败了37.05%的用户
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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root==null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        TreeNode last = null;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.peek();
            if(p.right!=null&& last!=p.right) p=p.right;
            else {
                last=p;
                res.add(stack.pop().val);
                p=null;
            }
        }
        return res;
    }
}