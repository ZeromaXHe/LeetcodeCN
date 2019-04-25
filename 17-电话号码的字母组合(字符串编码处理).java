import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> ans = new LinkedList<>();
        if(digits.isEmpty()) return ans;//注意空的情况
        StringBuilder sb = new StringBuilder();
        String[] numToChar = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int[] num = new int[digits.length()];
        int count=1;
        int now;
        String check;
        
        for(int i=0;i<digits.length();i++){
            num[i]=numToChar[digits.charAt(i)-'2'].length();
            count*=num[i];
        }
        for(int i=0;i<count;i++){
            now = i;
            for(int j=0;j<digits.length();j++){
                check =numToChar[digits.charAt(j)-'2'];
                sb.append(check.charAt(now%num[j]));
                now/=num[j];
            }
            ans.add(sb.toString());
            sb.delete( 0, sb.length() );//清空sb
        }
        return ans;
    }
}