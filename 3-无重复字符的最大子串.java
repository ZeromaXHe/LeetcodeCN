class Solution {
    public int lengthOfLongestSubstring(String s) {
    	int len=s.length();
    	int ans = 0;
        Map<Character,Integer> hashMap = new HashMap<>();
        int pos = 0;
        for (int i = 0; i<len; i++) {
        	if(hashMap.containsKey(s.charAt(i))){
        		pos = Math.max(hashMap.get(s.charAt(i)),pos);
        	}
        	ans = Math.max(ans, i-pos+1);
        	hashMap.put(s.charAt(i),i+1);
        }
        return ans;
    }
}