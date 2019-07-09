//执行用时 :1 ms, 在所有 Java 提交中击败了87.79%的用户
//内存消耗 :33.5 MB, 在所有 Java 提交中击败了14.67%的用户
class Solution {
    public int integerBreak(int n) {
        long max = Long.MIN_VALUE;
        for(int i=2;i<=n;i++){
            long product = 1L;
            for(int j=0;j<i;j++){
                if(j<n%i) product*=(n/i+1);
                else product*=n/i;
            }
            if(product>max) max=product;
            else break;
        }
        return (int)max;
    }
}