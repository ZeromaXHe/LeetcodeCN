//执行用时 :5 ms, 在所有 Java 提交中击败了46.18%的用户
//内存消耗 :35.5 MB, 在所有 Java 提交中击败了80.56%的用户
class Solution {
    public int longestPalindrome(String s) {
        boolean[] abc = new boolean[26];
        boolean[] ABC_upper = new boolean[26];
        int singleCount = 0;
        int count = 0;
        for(char c:s.toCharArray()){
            if(Character.isLowerCase(c)){
                if(abc[c-'a']) {
                    count+=2;
                    singleCount--;
                }
                else singleCount++;
                abc[c-'a']=!abc[c-'a'];
            }
            else{
                if(ABC_upper[c-'A']) {
                    count+=2;
                    singleCount--;
                }
                else singleCount++;
                ABC_upper[c-'A']=!ABC_upper[c-'A'];
            }
        }
        if(singleCount>0) count++;
        return count;
    }
}