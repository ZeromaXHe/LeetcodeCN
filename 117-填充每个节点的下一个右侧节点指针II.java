//执行用时 :6 ms, 在所有 Java 提交中击败了54.24%的用户
//内存消耗 :66.4 MB, 在所有 Java 提交中击败了7.23%的用户
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        Node nextFirst = null;
        Node temp = null;
        Node pre = null;
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp==nextFirst) {
                nextFirst=null;
            }
            else if(pre!=null) pre.next = temp;
            pre = temp;
            if(temp.left!=null){
                queue.add(temp.left);
                if(nextFirst==null) nextFirst = temp.left;
            }
            if(temp.right!=null){
                queue.add(temp.right);
                if(nextFirst==null) nextFirst = temp.right;
            }
        }
        return root;
    }
}