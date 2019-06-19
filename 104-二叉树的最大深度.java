//执行用时 :2 ms, 在所有 Java 提交中击败了16.73%的用户
//内存消耗 :36.6 MB, 在所有 Java 提交中击败了64.70%的用户
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
    public int maxDepth(TreeNode root) {
        int res = 1;
        if(root==null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode nextFirst = null;
        TreeNode temp = null;
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp==nextFirst) {
                nextFirst=null;
                res++;
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
        return res;
    }
}