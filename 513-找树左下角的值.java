//执行用时 :5 ms, 在所有Java提交中击败了46.79%的用户
//内存消耗 :38.5 MB, 在所有Java提交中击败了61.43%的用户
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
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int added = 0;
        int polled = 1;
        queue.add(root);
        if(root.left!=null) {
            queue.add(root.left);
            added++;
        }
        if(root.right!=null){
            queue.add(root.right);
            added++;
        }
        TreeNode tmp = null;
        int temp = added;
        while(added>0){
            temp=added;
            added=0;
            for(int i=0;i<polled;i++) {
                tmp=queue.poll();
                if(tmp.left!=null) {
                    queue.add(tmp.left);
                    added++;
                }
                if(tmp.right!=null){
                    queue.add(tmp.right);
                    added++;
                }
            }
            polled=temp;
        }
        return queue.poll().val;
    }
}
//执行用时 :4 ms, 在所有Java提交中击败了71.08%的用户
//内存消耗 :38.7 MB, 在所有Java提交中击败了57.62%的用户

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int added = 1;
        int polled = 1;
        queue.add(root);
        TreeNode tmp = null;
        TreeNode res = root;
        while(added>0){
            added=0;
            res=queue.peek();
            for(int i=0;i<polled;i++) {
                tmp=queue.poll();
                if(tmp.left!=null) {
                    queue.add(tmp.left);
                    added++;
                }
                if(tmp.right!=null){
                    queue.add(tmp.right);
                    added++;
                }
            }
            polled=added;
        }
        return res.val;
    }
}