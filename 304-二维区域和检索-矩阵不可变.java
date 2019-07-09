//执行用时 :124 ms, 在所有 Java 提交中击败了80.62%的用户
//内存消耗 :47.8 MB, 在所有 Java 提交中击败了73.08%的用户
class NumMatrix {
    private int[][] numMatrix;
    
    public NumMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return;
        numMatrix = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0&j==0) numMatrix[i][j]=matrix[0][0];
                else if(i==0) numMatrix[i][j]=numMatrix[0][j-1]+matrix[0][j];
                else if(j==0) numMatrix[i][j]=numMatrix[i-1][0]+matrix[i][0];
                else numMatrix[i][j]=numMatrix[i-1][j]+numMatrix[i][j-1]-numMatrix[i-1][j-1]+matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(numMatrix==null||row1<0) return 0;
        if(row1!=0&&col1!=0) return numMatrix[row2][col2]-numMatrix[row2][col1-1]-numMatrix[row1-1][col2]+numMatrix[row1-1][col1-1];
        else if(col1!=0) return numMatrix[row2][col2]-numMatrix[row2][col1-1];
        else if(row1!=0) return numMatrix[row2][col2]-numMatrix[row1-1][col2];
        else return numMatrix[row2][col2];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */