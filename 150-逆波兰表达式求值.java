//执行用时 : 13 ms, 在Evaluate Reverse Polish Notation的Java提交中击败了82.42% 的用户
//内存消耗 : 38.3 MB, 在Evaluate Reverse Polish Notation的Java提交中击败了37.20% 的用户
class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i=0;i<tokens.length;i++){
            switch(tokens[i]){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    int num1;
                    int num2;
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2-num1);
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2/num1);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
                    break;
            }
        }
        return stack.pop();
    }
}