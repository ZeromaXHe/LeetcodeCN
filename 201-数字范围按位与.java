//执行用时 :32 ms, 在所有 Java 提交中击败了91.76%的用户
//内存消耗 :37.8 MB, 在所有 Java 提交中击败了7.64%的用户
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        for(;m!=n;offset++){
            m>>=1;
            n>>=1;
        }
        return n<<offset;
    }
}