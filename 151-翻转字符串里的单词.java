//执行用时 :19 ms, 在所有 Java 提交中击败了37.35%的用户
//内存消耗 :40.7 MB, 在所有 Java 提交中击败了62.50%的用户
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strs = s.trim().split("[ ]+");
        for(int i=strs.length-1;i>=0;i--){
            if(i!=strs.length-1) sb.append(' ');
            sb.append(strs[i]);
        }
        return sb.toString();
    }
}