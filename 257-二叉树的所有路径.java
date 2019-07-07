//执行用时 :3 ms, 在所有 Java 提交中击败了95.40%的用户
//内存消耗 :36.2 MB, 在所有 Java 提交中击败了97.17%的用户
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
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> res = new LinkedList<>();
        if(root!=null){
            String path = ""+root.val;
            resPath(root,path,res);
        }
        return res;
    }
    
    private void resPath(TreeNode root, String path, List<String> res){
        if(root.left==null&&root.right==null) res.add(path);
        else {
            if(root.left!=null){
                resPath(root.left,path+"->"+root.left.val,res);
            }
            if(root.right!=null){
                resPath(root.right,path+"->"+root.right.val,res);
            }
        }
    }
}