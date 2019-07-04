//执行用时 :136 ms, 在所有 Java 提交中击败了71.47%的用户
//内存消耗 :61.7 MB, 在所有 Java 提交中击败了28.87%的用户
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private LinkedList<Integer> ll = new LinkedList<>();
    private Iterator<Integer> iter;
    public BSTIterator(TreeNode root) {
        if(root!=null) preorderTraverse(root);
        iter = ll.iterator();
    }
    
    private void preorderTraverse(TreeNode root){
        if(root.left!=null)preorderTraverse(root.left);
        ll.add(root.val);
        if(root.right!=null)preorderTraverse(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return iter.next();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return iter.hasNext();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */