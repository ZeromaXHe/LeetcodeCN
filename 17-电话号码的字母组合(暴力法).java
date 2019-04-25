import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        List<String> result = new ArrayList<>();
        
        String[] numToChar = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int len = digits.length();
        int pos=0;
        int posNow=0;
        for(int i=0;i<len;i++){
        	char c = digits.charAt(i);
        	if(result.size()!=0){
        		for(int j=pos;j<posNow;j++){
        			for(int k=0;k<numToChar[c-'2'].length();k++){
        				System.out.println(result.get(j)+numToChar[c-'2'].charAt(k));
        				result.add(result.get(j)+numToChar[c-'2'].charAt(k));
        			}
        		}
        	}
        	else{
        		for(int k=0;k<numToChar[c-'2'].length();k++){
        			System.out.println(""+numToChar[c-'2'].charAt(k));
        			result.add(""+numToChar[c-'2'].charAt(k));
        		}
        	}
        	pos=posNow;
        	posNow = result.size();
        }
        for(int i=pos;i<posNow;i++){
        	ans.add(result.get(i));
        }
        return ans;
    }
}