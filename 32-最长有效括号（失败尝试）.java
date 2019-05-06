class Solution {
    public int longestValidParentheses(String s) {
    	if(s==null||s.length()<2) return 0;
        LinkedList<Character> stack = new LinkedList<>();
        int len = s.length();
        char[] ca = s.toCharArray();
        int tmpLen=0;
        int testLen = 0;
        int longestLen = 0;
        for(int i=0;i<len;i++){
        	if(ca[i]=='(') {
        		stack.push(ca[i]);
        	}
        	else if(stack.isEmpty()){
        		if(testLen>longestLen)longestLen=testLen;
        		tmpLen = 0;
        		testLen = 0;
        	}else{
        		stack.pop();
        		if(stack.isEmpty()){
        			testLen+=tmpLen;
        			tmpLen=0;
        		}
        		else tmpLen+=2;
        	}
        }
        if(stack.isEmpty()){
        	testLen+=tmpLen;
        	tmpLen=0;
        }
        else tmpLen+=2;
        if(testLen>longestLen)longestLen=testLen;
        return longestLen;
    }
    private int longest(char[] ca, int from, int to){
    	if(to-from<1) return 0;
    	if(ca[from]==')') return longest(ca,from+1,to);
    	else if(ca[to]==')')return longest(ca,from+1,to-1)+1;
    	else return longest(ca,from,to-1);
    }
}