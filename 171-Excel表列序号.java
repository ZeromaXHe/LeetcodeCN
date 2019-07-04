//执行用时 :5 ms, 在所有 Java 提交中击败了98.36%的用户
//内存消耗 :35.7 MB, 在所有 Java 提交中击败了37.80%的用户
class Solution {
    public int titleToNumber(String s) {
        char[] chs = s.toCharArray();
        int order = 0;
        for(int i=0;i<chs.length;i++){
            order*=26;
            order+=chs[i]-'A'+1;
        }
        return order;
    }
}