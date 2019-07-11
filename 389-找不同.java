//执行用时 :4 ms, 在所有 Java 提交中击败了39.59%的用户
//内存消耗 :36 MB, 在所有 Java 提交中击败了77.09%的用户
class Solution {
    public char findTheDifference(String s, String t) {
        int[] abc = new int[26];
        for(int i=0;i<s.length();i++){
            abc[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            char tch = t.charAt(i);
            if(abc[tch-'a']==0) return tch;
            abc[tch-'a']--;
        }
        return '#';
    }
}