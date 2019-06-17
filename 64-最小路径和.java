//执行用时 :5 ms, 在所有Java提交中击败了80.13%的用户
//内存消耗 :39.6 MB, 在所有Java提交中击败了86.58%的用户
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(i==0&&j==0) continue;
                if(i==0) grid[i][j]+=grid[i][j-1];
                else if(j==0) grid[i][j]+=grid[i-1][j];
                else grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[n-1][m-1];
    }
}