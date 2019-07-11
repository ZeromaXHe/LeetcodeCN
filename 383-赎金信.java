//执行用时 :7 ms, 在所有 Java 提交中击败了84.26%的用户
//内存消耗 :46.8 MB, 在所有 Java 提交中击败了71.47%的用户
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()) return false;
        char[] chs1 = ransomNote.toCharArray();
        char[] chs2 = magazine.toCharArray();
        int[] abc = new int[26];
        int[] abc2 = new int[26];
        for(int i=0;i<chs1.length;i++){
            abc[chs1[i]-'a']++;
        }
        for(int i=0;i<chs2.length;i++){
            abc2[chs2[i]-'a']++;
        }
        for(int i=0;i<26;i++){
            if(abc[i]>abc2[i]) return false;
        }
        return true;
    }
}