//执行用时 :2 ms, 在所有 Java 提交中击败了94.50%的用户
//内存消耗 :35.3 MB, 在所有 Java 提交中击败了44.22%的用户
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode nextFirst = null;
        TreeNode temp = null;
        boolean leftToRight = true;
        List<Integer> list = new LinkedList<>();
        while(!queue.isEmpty()){
            /*while里面可以换成：
            temp = queue.poll();
            if(temp==nextFirst) {
                nextFirst=null;
                res.add(list);
                list = new LinkedList<>();
                leftToRight=!leftToRight;
                continue;
            }
            if(LeftToRight) list.add(temp.val);
            else list.addFirst(temp.val);
            if(temp.left!=null){
                queue.add(temp.left);
                if(nextFirst==null) nextFirst = temp.left;
            }
            if(temp.right!=null){
                queue.add(temp.right);
                if(nextFirst==null) nextFirst = temp.right;
            }
            */
            if(leftToRight) temp = queue.peek();
            else temp = queue.peekLast();
            
            if(temp==nextFirst) {
                nextFirst=null;
                res.add(list);
                list = new LinkedList<>();
                leftToRight=!leftToRight;
                continue;
            }
            list.add(temp.val);
            if(leftToRight){
                if(temp.left!=null){
                    queue.add(temp.left);
                    if(nextFirst==null) nextFirst = temp.left;
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                    if(nextFirst==null) nextFirst = temp.right;
                }
                queue.poll();
            }
            else{
                if(temp.right!=null){
                    queue.addFirst(temp.right);
                    if(nextFirst==null) nextFirst = temp.right;
                }
                if(temp.left!=null){
                    queue.addFirst(temp.left);
                    if(nextFirst==null) nextFirst = temp.left;
                }
                queue.pollLast();
            }
        }
        if(list.size()>0) res.add(list);
        return res;
    }
}