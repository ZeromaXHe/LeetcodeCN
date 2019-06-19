//执行用时 :28 ms, 在所有 Java 提交中击败了58.83%的用户
//内存消耗 :36.8 MB, 在所有 Java 提交中击败了85.69%的用户
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
    int[] posorder;
    int[] inorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.posorder = postorder;
        this.inorder = inorder;
        return buildTree(0,0,inorder.length);
    }
    private TreeNode buildTree(int posStart, int inStart, int len){
        if(len==0) return null;
        TreeNode res = new TreeNode(posorder[posStart+len-1]);
        if(len>1){
            for(int i=inStart;i<inStart+len;i++){
                if(inorder[i]==posorder[posStart+len-1]){
                    res.left = buildTree(posStart,inStart,i-inStart);
                    res.right = buildTree(posStart+i-inStart,i+1,inStart+len-i-1);
                    break;
                }
            }
        }
        return res;
    }
}