//执行用时 :7 ms, 在所有 Java 提交中击败了82.73%的用户
//内存消耗 :40.7 MB, 在所有 Java 提交中击败了41.09%的用户
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for(char c1:s.toCharArray()){
            alphabet[c1-'a']++;
        }
        for(char c2:t.toCharArray()){
            alphabet[c2-'a']--;
        }
        for(int i:alphabet){
            if(i!=0) return false;
        }
        return true;
    }
}