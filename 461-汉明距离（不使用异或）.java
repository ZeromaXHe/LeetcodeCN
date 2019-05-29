//执行用时 : 1 ms, 在Hamming Distance的Java提交中击败了99.52% 的用户
//内存消耗 : 32.8 MB, 在Hamming Distance的Java提交中击败了78.42% 的用户
class Solution {
    public int hammingDistance(int x, int y) {
        int sum = 0;
        while(x>0||y>0) {
            if ((x & 1) != (y & 1))
                sum++;
            x >>= 1;
            y >>= 1;
        }
        return sum;
    }
}