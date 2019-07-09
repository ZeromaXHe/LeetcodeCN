//执行用时 :1 ms, 在所有 Java 提交中击败了62.93%的用户
//内存消耗 :33.2 MB, 在所有 Java 提交中击败了11.38%的用户
class Solution {
    public int bulbSwitch(int n) {
        int i=0;
        for(i=0;(i+1)*(i+1)<=n;i++);
        return i;
    }
}