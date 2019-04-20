class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if(strs.length==0) return "";
        int minLen=0x3f3f3f;
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<strs.length;i++){
        	if(strs[i].length()<minLen) minLen=strs[i].length();
        }
        label:
        for(int i=0;i<minLen;i++){
        	for(int j=1;j<strs.length;j++){
        		if(strs[j].charAt(i)!=strs[j-1].charAt(i)){
        			break label;
        		}
        	}
        	sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}