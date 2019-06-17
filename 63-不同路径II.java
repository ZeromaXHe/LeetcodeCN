//执行用时 :1 ms, 在所有Java提交中击败了99.43%的用户
//内存消耗 :35.1 MB, 在所有Java提交中击败了48.14%的用户
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0].length==0) return 0;
        int m=obstacleGrid[0].length;
        int n=obstacleGrid.length;
        int[] memo = new int[m];
        for(int i=0;i<m;i++){
            if(obstacleGrid[0][i]==0) memo[i]=1;
            else break;
        }
        for(int i=1;i<n;i++){
            for(int j = 0;j<m;j++){
                if(obstacleGrid[i][j]==1) memo[j]=0;
                else if(j!=0) memo[j]+=memo[j-1];
            }
        }
        return memo[m-1];
    }
}