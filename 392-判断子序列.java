//执行用时 :30 ms, 在所有 Java 提交中击败了44.21%的用户
//内存消耗 :50.9 MB, 在所有 Java 提交中击败了73.74%的用户
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length()==0) return true;
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }
}