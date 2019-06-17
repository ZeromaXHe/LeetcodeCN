//执行用时 :1 ms, 在所有Java提交中击败了93.15%的用户
//内存消耗 :32.8 MB, 在所有Java提交中击败了18.56%的用户
class Solution {
    public int uniquePaths(int m, int n) {
        int[] memo = new int[m];
        Arrays.fill(memo,1);
        for(int i=1;i<n;i++){
            for(int j = 1;j<m;j++){
                memo[j]+=memo[j-1];
            }
        }
        return memo[m-1];
    }
}