//执行用时 :2 ms, 在所有 Java 提交中击败了98.88%的用户
//内存消耗 :36.1 MB, 在所有 Java 提交中击败了40.00%的用户
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode nextFirst = null;
        TreeNode pre = null;
        TreeNode temp = null;
        while(!queue.isEmpty()){
            pre = temp;
            temp = queue.poll();
            if(temp==nextFirst) {
                nextFirst=null;
                res.add(pre.val);
            }
            if(temp.left!=null){
                queue.add(temp.left);
                if(nextFirst==null) nextFirst = temp.left;
            }
            if(temp.right!=null){
                queue.add(temp.right);
                if(nextFirst==null) nextFirst = temp.right;
            }
        }
        res.add(temp.val);
        return res;
    }
}