//执行用时 :1 ms, 在所有 Java 提交中击败了88.13%的用户
//内存消耗 :33.6 MB, 在所有 Java 提交中击败了92.36%的用户
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
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
            if(!isEqual(pPeek.left,qPeek.left)) return false;
            if(!isEqual(pPeek.right,qPeek.right)) return false;
            if(pPeek.left!=null){
                queueP.add(pPeek.left);
                queueQ.add(qPeek.left);
            }
            if(pPeek.right!=null){
                queueP.add(pPeek.right);
                queueQ.add(qPeek.right);
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