class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
    	List<Integer> ans = new ArrayList<>(); 
    	if(s.equals("")||words.length==0) return ans;//这个好坑，为了171/173用例： "" []；172/173用例："a" []而添加
    	
    	int maxLen = -1;
    	int minLen = 0x3f3f3f3f;
    	int totalLen = 0;
    	int len;
    	String testS;

    	HashMap<String, Integer> hm = new HashMap<>();
    	HashMap<String, Integer> wordsNum = new HashMap<>();
    	HashMap<String, Integer> testWordsNum = new HashMap<>();
    	for(int i=0;i<words.length;i++){
    		len = words[i].length();
    		if(len>maxLen) maxLen = len;
    		if(len<minLen) minLen = len;
    		totalLen += len;
    		hm.putIfAbsent(words[i],len);
    		wordsNum.put(words[i],wordsNum.containsKey(words[i])?wordsNum.get(words[i])+1:1);
    	}
        
        for(int i=0;i<s.length()-totalLen+1;i++){
        	testWordsNum.clear();
        	int pos = i;
        	int flag = 1;
        	while(pos<i+totalLen&&flag==1){
        		flag = 0;
        		for(int j=minLen;j<=maxLen;j++){
        			if(hm.containsValue(j)){
        				testS=s.substring(pos,pos+j);
        				if(hm.containsKey(testS)&&(!testWordsNum.containsKey(testS)||testWordsNum.get(testS)<wordsNum.get(testS))){
        					if(testWordsNum.containsKey(testS)) testWordsNum.put(testS,testWordsNum.get(testS)+1);
        					else testWordsNum.put(testS,1);
        					pos+=j;
        					flag = 1;
        					break;
        				}
        			}
        		}

        	}
        	if(pos==i+totalLen){
        		ans.add(i);
        	}
        }
        return ans;
    }
}