//执行用时 :4 ms, 在所有 Java 提交中击败了14.55%的用户
//内存消耗 :34.3 MB, 在所有 Java 提交中击败了79.72%的用户
class Solution {
    public int trailingZeroes(int n) {
        int count5 = 0;
        while(n>0){
            count5+=n/5;
            n/=5;
        }
        return count5;
    }
}