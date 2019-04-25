class Solution {
    public String convert(String s, int numRows) {
        if (numRows==1) return s;//这个特例有点坑
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i<len; i+=2*numRows-2) {
        	sb.append(s.charAt(i));
        }
        for(int j=1;j<numRows-1;j++){
        	for (int i = j; i<len; i+=2*numRows-2) {
        		sb.append(s.charAt(i));
        		if(2*(numRows-1-j)+i<len){
        			sb.append(s.charAt(2*(numRows-1-j)+i));
        		}
        	}
    	}
    	for(int i=numRows-1; i<len; i+=2*numRows-2) {
    		sb.append(s.charAt(i));
    	}
    	return sb.toString();
    }
}