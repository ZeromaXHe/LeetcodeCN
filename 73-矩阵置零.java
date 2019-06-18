//执行用时 :3 ms, 在所有 Java 提交中击败了82.77%的用户
//内存消耗 :55.5 MB, 在所有 Java 提交中击败了18.91%的用户
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row = false;
        boolean col = false;
        for(int i = 0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(i==0) row=true;
                    if(j==0) col=true;
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i = 1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[0][j]==0||matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(row) for(int i=0;i<matrix[0].length;i++) matrix[0][i]=0;
        if(col) for(int i=0;i<matrix.length;i++) matrix[i][0]=0;
    }
}