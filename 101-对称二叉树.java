//执行用时 :3 ms, 在所有 Java 提交中击败了37.85%的用户
//内存消耗 :34.7 MB, 在所有 Java 提交中击败了86.52%的用户
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        TreeNode p = root.left;
        TreeNode q = root.right;
        if(p==null&&q==null) return true;
        if(!isEqual(p,q)) return false;
        LinkedList<TreeNode> queueP = new LinkedList<>();
        LinkedList<TreeNode> queueQ = new LinkedList<>();
        queueP.add(p);
        queueQ.add(q);
        TreeNode pPeek = null;
        TreeNode qPeek = null;
        while(!queueP.isEmpty()){
            pPeek = queueP.peek();
            qPeek = queueQ.peek();
            if(!isEqual(pPeek,qPeek)) return false;
            if(!isEqual(pPeek.left,qPeek.right)) return false;
            if(!isEqual(pPeek.right,qPeek.left)) return false;
            if(pPeek.left!=null){
                queueP.add(pPeek.left);
                queueQ.add(qPeek.right);
            }
            if(pPeek.right!=null){
                queueP.add(pPeek.right);
                queueQ.add(qPeek.left);
            }
            queueP.poll();
            queueQ.poll();
        }
        return true;
    }
    private boolean isEqual(TreeNode p,TreeNode q){
        if(p==null){
            if(q==null) return true;
            else return false;
        }
        else{
            if(q==null) return false;
            else{
                if(p.val!=q.val) return false;
                else return true;
            }
        }
    }
}