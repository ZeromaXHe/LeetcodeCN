import java.util.*;
class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] ca = s.toCharArray();
        for(int i=0;i<ca.length;i++){
        	if(ca[i]=='('||ca[i]=='['||ca[i]=='{'){
        		stack.push(ca[i]);
        	}
        	else{
        		if(stack.size()==0) return false;//注意只有右括号时空栈可能会pop失败。
        		switch(ca[i]){
        			case ')':
        				if(stack.peek()=='(')stack.pop();
        				else return false;
        				break;
        			case ']':
        				if(stack.peek()=='[')stack.pop();
        				else return false;
        				break;
        			case '}':
        				if(stack.peek()=='{')stack.pop();
        				else return false;	
        				break;
        			default:
        				return false;
        		}
        	}

        }
        if(stack.size()==0)return true;
        else return false;
    }
}