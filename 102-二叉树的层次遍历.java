//执行用时 :2 ms, 在所有 Java 提交中击败了90.87%的用户
//内存消耗 :35.9 MB, 在所有 Java 提交中击败了68.36%的用户
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode nextFirst = null;
        TreeNode temp = null;
        List<Integer> list = new LinkedList<>();
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp==nextFirst) {
                nextFirst=null;
                res.add(list);
                list = new LinkedList<>();
            }
            list.add(temp.val);
            if(temp.left!=null){
                queue.add(temp.left);
                if(nextFirst==null) nextFirst = temp.left;
            }
            if(temp.right!=null){
                queue.add(temp.right);
                if(nextFirst==null) nextFirst = temp.right;
            }
        }
        if(list.size()>0) res.add(list);
        return res;
    }
}