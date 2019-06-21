//执行用时 :4 ms, 在所有 Java 提交中击败了63.40%的用户
//内存消耗 :35.8 MB, 在所有 Java 提交中击败了99.84%的用户
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
    LinkedList<Integer> list = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return res;
        list.add(root.val);
        if(root.left==null&&root.right==null) {
            if(root.val==sum) res.add(new LinkedList(list));
        }
        else if(root.left==null) pathSum(root.right, sum-root.val);
        else if(root.right==null) pathSum(root.left,sum-root.val);
        else {
            pathSum(root.left,sum-root.val);
            pathSum(root.right, sum-root.val);
        }
        list.removeLast();
        return res;
    }
}