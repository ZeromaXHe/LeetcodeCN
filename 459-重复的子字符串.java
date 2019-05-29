class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length()<2) return false;
        String twoS = s+s;
        return twoS.substring(1,twoS.length()-1).contains(s);
    }
}