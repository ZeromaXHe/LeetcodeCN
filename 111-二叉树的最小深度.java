//执行用时 :2 ms, 在所有 Java 提交中击败了17.00%的用户
//内存消耗 :36.8 MB, 在所有 Java 提交中击败了84.54%的用户
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
    public int minDepth(TreeNode root) {
        int res = 0;
        if(root==null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        res++;
        TreeNode nextFirst = null;
        TreeNode temp = null;
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp==nextFirst) {
                nextFirst=null;
                res++;
            }
            if(temp!=null){
                if(temp.left==null && temp.right==null) return res;
                queue.add(temp.left);
                if(nextFirst==null && temp.left!=null) nextFirst = temp.left;
                queue.add(temp.right);
                if(nextFirst==null && temp.right!=null) nextFirst = temp.right; 
            }
        }
        return res;
    }
}
//执行用时 :1 ms, 在所有 Java 提交中击败了98.07%的用户
//内存消耗 :36.6 MB, 在所有 Java 提交中击败了92.70%的用户
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if(root.left==null&&root.right==null){
            return 1;
        } else if(root.left==null){
            return minDepth(root.right)+1;
        } else if(root.right==null){
            return minDepth(root.left)+1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}