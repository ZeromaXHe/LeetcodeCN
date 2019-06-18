//执行用时 :16 ms, 在所有 Java 提交中击败了48.05%的用户
//内存消耗 :39.6 MB, 在所有 Java 提交中击败了63.12%的用户
class Solution {
    public int longestValidParentheses(String s) {
        boolean[] valid = new boolean[s.length()];
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        for(int i=0;i<valid.length;i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                stack2.push(i);
            }
            else{
                if(stack.peek()=='('&&s.charAt(i)==')'){
                    stack.pop();
                    valid[i]=true;
                    valid[stack2.pop()]=true;
                }
                else{
                    stack.push(s.charAt(i));
                    stack2.push(i);
                }
            }
        }
        int max=0;
        int temp=0;
        for(int i=0;i<valid.length;i++){
            if(valid[i]){
                temp++;
                if(i==valid.length-1 && temp>max) max=temp;
            }
            else{
                if(temp>max) max=temp;
                temp=0;
            }
        }
        return max;
    }
}