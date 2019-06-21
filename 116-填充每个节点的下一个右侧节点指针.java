//执行用时 :3 ms, 在所有 Java 提交中击败了21.12%的用户
//内存消耗 :37.8 MB, 在所有 Java 提交中击败了49.80%的用户
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
        int count = 0;
        int maxCount = 1;
        boolean stop = false;
        Node temp = null;
        Node pre = null;
        while(!queue.isEmpty()){
            temp = queue.poll();
            count++;
            if(pre!=null) pre.next = temp;
            if(count==maxCount) {
                maxCount<<=1;
                count=0;
                pre = null;
            }
            else pre = temp;
            if(temp.left==null) stop = true;
            if(!stop){
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
        return root;
    }
}