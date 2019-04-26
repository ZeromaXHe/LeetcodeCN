import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
    	List<String> ans = new LinkedList<>();
    	if(n==0) return ans;
        StringBuilder sb = new StringBuilder();
        int[] num = new int[n];
        int possible = 1;
        for (int i=1; i<=n; i++) {
        	possible*=i;
        }
        for (int i=n;i<possible;i++){
        	for(int j=n-1;j>=0;j--){
        		num[j]=i%(j+1);
        	}
        	int count = n;
        	for(int j=0;j<n;j++){
        		sb.append('(');
        		for(int k=0;k<num[j];k++){
        			sb.append(')');
        			count--;
        		}
        	}
        	while(count>0){
        		sb.append(')');
        		count--;
        	}
        	ans.add(sb.toString());
        	sb.delete(0,sb.length());
        }
        return ans;
    }
}