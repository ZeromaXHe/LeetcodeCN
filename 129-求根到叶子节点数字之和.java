//执行用时 :3 ms, 在所有 Java 提交中击败了30.80%的用户
//内存消耗 :35.6 MB, 在所有 Java 提交中击败了40.47%的用户
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
    public int sumNumbers(TreeNode root) {
        int res = 0;
        int temp = 0;
        LinkedList<TreeNode> stack = new LinkedList();
        TreeNode p = root;
        TreeNode last = null;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                temp*=10;
                temp+=p.val;
                stack.push(p);
                p=p.left;
            }
            p=stack.peek();
            if(p.right!=null&& last!=p.right) p=p.right;
            else {
                if(p.left==null&&p.right==null) {
                    res+=temp;
                    //System.out.println("res:"+res+",temp:"+temp);
                }
                last=p;
                stack.pop();
                temp/=10;
                p=null;
            }
        }
        return res;
    }
}