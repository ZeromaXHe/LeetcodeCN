//执行用时 :3 ms, 在所有 Java 提交中击败了98.63%的用户
//内存消耗 :33.3 MB, 在所有 Java 提交中击败了18.25%的用户
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n&1;
            n >>= 1;
        }
        return res;
    }
}