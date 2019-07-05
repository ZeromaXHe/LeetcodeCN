//执行用时 :4 ms, 在所有 Java 提交中击败了89.55%的用户
//内存消耗 :30.4 MB, 在所有 Java 提交中击败了5.27%的用户
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i <= 32; i++) {
            int tmp = n >> i;
            tmp = tmp & 1;
            tmp = tmp << (31 - i);
            res |= tmp;
        }
        return res;
    }
}