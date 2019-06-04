class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null||len==0) return 0;
        String sTrim = s.trim();
        int len = sTrim.length();
        if(sTrim.lastIndexOf(' ')==-1) return len;
        else return len-sTrim.lastIndexOf(' ')-1;
    }
}