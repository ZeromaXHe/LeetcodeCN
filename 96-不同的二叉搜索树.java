//执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗 :33 MB, 在所有 Java 提交中击败了9.48%的用户
class Solution {
    public int numTrees(int n) {
        if(n<=0) return 1;
        int[] result = new int[n+1];
        result[0] = 1;
        for(int i=1;i<=n;i++){
            int res = 0;
            for(int j=1;j<=i;j++){
                res+= result[j-1]*result[i-j];
            }
            result[i]=res;
        }
        return result[n];
    }
}