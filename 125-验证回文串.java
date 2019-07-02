//执行用时 :12 ms, 在所有 Java 提交中击败了73.46%的用户
//内存消耗 :39.6 MB, 在所有 Java 提交中击败了47.60%的用户
class Solution {
    public boolean isPalindrome(String s) {
        if(s==null||"".equals(s)||s.length()==1) return true;
        char[] chs = s.toCharArray();
        int p1=0;
        int p2=s.length()-1;
        while(p1<p2){
            while(p1<=p2&&!Character.isLetterOrDigit(chs[p1])){
                p1++;
            }
            while(p1<=p2&&!Character.isLetterOrDigit(chs[p2])){
                p2--;
            }
            if(p1>p2) return true;
            if(Character.toLowerCase(chs[p1])!=Character.toLowerCase(chs[p2])){
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}