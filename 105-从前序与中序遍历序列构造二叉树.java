//执行用时 :32 ms, 在所有 Java 提交中击败了50.28%的用户
//内存消耗 :37 MB, 在所有 Java 提交中击败了77.96%的用户
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
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTree(0,preorder.length,0,inorder.length);
    }
    private TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd){
        if(preStart==preEnd||inStart==inEnd) return null;
        TreeNode res = new TreeNode(preorder[preStart]);
        for(int i=inStart;i<inEnd;i++){
            if(inorder[i]==preorder[preStart]){
                res.left = buildTree(preStart+1,preStart+1+i-inStart,inStart,i);
                res.right = buildTree(preStart+1+i-inStart,preEnd,i+1,inEnd);
                break;
            }
        }
        return res;
    }
}