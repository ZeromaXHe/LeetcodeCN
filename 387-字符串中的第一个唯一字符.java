//执行用时 :13 ms, 在所有 Java 提交中击败了87.30%的用户
//内存消耗 :37.8 MB, 在所有 Java 提交中击败了93.80%的用户
class Solution {
    public int firstUniqChar(String s) {
        int[] abc = new int[26];
        for(int i=0;i<s.length();i++){
            abc[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(abc[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }
}